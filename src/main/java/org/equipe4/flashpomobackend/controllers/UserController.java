package org.equipe4.flashpomobackend.controllers;

import org.equipe4.flashpomobackend.dao.IUser;
import org.equipe4.flashpomobackend.dao.ResponseUserEditDTO;
import org.equipe4.flashpomobackend.dao.UserEditRequestDTO;
import org.equipe4.flashpomobackend.models.User;
import org.equipe4.flashpomobackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The UserController class is a REST controller that handles user-related operations.
 * It provides an endpoint to fetch the user information.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUser dao;

    /**
     * Retrieves the user information.
     *
     * @return a ResponseEntity containing the success message "User fetched successfully"
     */
    @GetMapping
    public List<User> getUser() {
        return (List<User>) this.userRepository.findAll();
    }

    /**
     * Handles the PUT request to update a user's information.
     *
     * @param userId The unique identifier of the user to be updated.
     * @param body   The request body containing the updated user information.
     * @return A ResponseEntity containing the updated user information or an error message.
     * If the user ID is not provided or invalid, a bad request response is returned.
     * If the user is not found, a not found response is returned.
     * If the required fields are not filled, a bad request response is returned.
     * Otherwise, an OK response with the updated user information is returned.
     */
    @PutMapping("/{userId}")
    public ResponseEntity<ResponseUserEditDTO> editUser(@PathVariable("userId") Long userId, @RequestBody UserEditRequestDTO body) {
        try {
            if (userId == null || userId <= 0) {
                return ResponseEntity.badRequest().body(new ResponseUserEditDTO("User ID is required", null, null, null, null));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseUserEditDTO("User ID is not a number", null, null, null, null));
        }
        Optional<User> user = this.userRepository.findById(Math.toIntExact(userId));

        boolean userNotFound = user.isEmpty();
        if (userNotFound) {
            return ResponseEntity.notFound().build();
        }

        boolean fieldValueFilled;
        User newUser = user.get();

        fieldValueFilled = !body.updatedAt().isBlank();
        if (fieldValueFilled) {
            newUser.setUpdatedAt(body.updatedAt());
        } else {
            return ResponseEntity.badRequest().body(new ResponseUserEditDTO("Field 'updatedAt' if required", null, null, null, null));
        }

        fieldValueFilled = !body.name().isBlank();
        if (fieldValueFilled) {
            newUser.setName(body.name());
        }

        fieldValueFilled = !body.email().isBlank();
        if (fieldValueFilled) {
            newUser.setEmail(body.email());
        }

        fieldValueFilled = !body.password().isBlank();
        if (fieldValueFilled) {
            newUser.setPassword(body.password());
        }

        fieldValueFilled = body.avatar() != null;
        if (fieldValueFilled) {
            newUser.setAvatar(body.avatar());
        }

        fieldValueFilled = !body.role().isBlank();
        if (fieldValueFilled) {
            newUser.setRole(body.role());
        }

        User updatedUser = this.userRepository.save(newUser);

        return ResponseEntity.ok().body(new ResponseUserEditDTO(
                updatedUser.getName(),
                updatedUser.getEmail(),
                updatedUser.getPassword(),
                updatedUser.getAvatar(),
                updatedUser.getRole()
        ));
    }
}