package org.punkdomus.runecraftacademy.controllers;

import lombok.RequiredArgsConstructor;
import org.punkdomus.runecraftacademy.dao.LoginRequestDTO;
import org.punkdomus.runecraftacademy.dao.LoginResponseDTO;
import org.punkdomus.runecraftacademy.dao.RegisterRequestDTO;
import org.punkdomus.runecraftacademy.dao.ResponseCommonDTO;
import org.punkdomus.runecraftacademy.infra.security.TokenService;
import org.punkdomus.runecraftacademy.models.User;
import org.punkdomus.runecraftacademy.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * The AuthController class is a REST controller that handles authentication-related operations.
 * It provides endpoints for user login and registration.
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    /**
     * Handles the login request.
     * It finds the user by the provided email, checks the password, and generates a JWT token if the user is authenticated.
     *
     * @param body the login request body containing the email and password
     * @return a ResponseEntity containing the user's name and the generated token, or a Bad Request response if the authentication fails
     */
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("Could not find user"));

        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
                return ResponseEntity.ok(new LoginResponseDTO(user.getName(), token, user.getUserId()));
        }

        return ResponseEntity.badRequest().build();
    }

    /**
     * Handles the registration request.
     * It checks if the email is already registered, and if not, creates a new user and generates a JWT token.
     *
     * @param body the registration request body containing the name, email, and password
     * @return a ResponseEntity containing the user's name and the generated token, or a Bad Request response if the email is already registered
     */
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        Optional<User> user = this.repository.findByEmail(body.email());


        if (user.isEmpty()) {
            User newUser = new User();

            newUser.setName(body.name());
            newUser.setEmail(body.email());
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setAvatar(body.avatar());
            newUser.setCreatedAt(body.createdAt());
            newUser.setStatus(body.status());
            newUser.setRole(body.role());

            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseCommonDTO("User created"));
        }

        return ResponseEntity.badRequest().body("Erro ao registrar o usuário.");
    }
}