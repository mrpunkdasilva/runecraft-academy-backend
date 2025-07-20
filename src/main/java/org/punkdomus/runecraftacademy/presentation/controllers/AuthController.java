package org.punkdomus.runecraftacademy.presentation.controllers;

import org.punkdomus.runecraftacademy.data.dao.LoginRequestDTO;
import org.punkdomus.runecraftacademy.data.dao.LoginResponseDTO;
import org.punkdomus.runecraftacademy.data.dao.RegisterRequestDTO;
import org.punkdomus.runecraftacademy.data.models.User;
import org.punkdomus.runecraftacademy.application.services.UserService;
import org.punkdomus.runecraftacademy.infra.security.TokenService;
import org.punkdomus.runecraftacademy.application.validation.ValidationFactory;
import org.punkdomus.runecraftacademy.application.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Força a recompilação
@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO data) {
        try {
            User user = userService.findUserByEmail(data.getEmail());
            if (user == null || !passwordEncoder.matches(data.getPassword(), user.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponseDTO(null, "Invalid credentials."));
            }
            var token = tokenService.generateToken(user);
            return ResponseEntity.ok(new LoginResponseDTO(token, "Login successful."));
        } catch (Exception e) {
            logger.error("An unexpected error occurred during login: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new LoginResponseDTO(null, "An unexpected error occurred."));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO data) {
        try {
            // Validate password
            Validator<String> passwordValidator = ValidationFactory.getValidator(String.class);
            if (!passwordValidator.isValid(data.getPassword())) {
                return ResponseEntity.badRequest().body(passwordValidator.getErrorMessage());
            }

            // Create a temporary User object for validation
            User tempUser = new User();
            tempUser.setName(data.getName());
            tempUser.setEmail(data.getEmail());

            // Validate user fields
            Validator<User> userValidator = ValidationFactory.getValidator(User.class);
            if (!userValidator.isValid(tempUser)) {
                return ResponseEntity.badRequest().body(userValidator.getErrorMessage());
            }

            // Check if the user already exists
            if (this.userService.findUserByEmail(data.getEmail()) != null) {
                return ResponseEntity.badRequest().body("User with this email already exists.");
            }

            User newUser = new User();
            newUser.setName(data.getName());
            newUser.setEmail(data.getEmail());
            newUser.setPassword(data.getPassword()); // Password will be encrypted in UserService

            User registeredUser = userService.registerUser(newUser);
            return ResponseEntity.ok(registeredUser);
        } catch (Exception e) {
            logger.error("An unexpected error occurred during registration: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred during registration.");
        }
    }
}