package org.equipe4.flashpomobackend.controllers;

import org.equipe4.flashpomobackend.dao.IUser;
import org.equipe4.flashpomobackend.dao.ResponseUserEditDTO;
import org.equipe4.flashpomobackend.dao.UserEditRequestDTO;
import org.equipe4.flashpomobackend.models.User;
import org.equipe4.flashpomobackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
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

    /**
     * Deletes a user by setting their status to false.
     * <p>
     * This method handles the DELETE request to deactivate a user account. It doesn't actually
     * remove the user from the database but instead sets their status to false, effectively
     * deactivating the account.
     *
     * @param userId The unique identifier of the user to be deleted. Must be a positive number.
     * @return A ResponseEntity containing a ResponseCommonDTO with a success or error message.
     * Possible responses:
     * - 200 OK with "User deleted with success" message if the user was successfully deactivated.
     * - 400 Bad Request with "User ID is required" message if the userId is null, non-positive, or invalid.
     * - 404 Not Found with "User not found" message if no user with the given ID exists.
     * - 500 Internal Server Error with an error message if an exception occurs during the deletion process.
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<ResponseCommonDTO> deleteUser(@PathVariable("userId") Long userId) {
        try {
            if (userId == null || userId <= 0) {
                ResponseEntity.ok().body(new ResponseCommonDTO("User ID is required"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body(new ResponseCommonDTO("User ID is required"));
        }

        Optional<User> user = this.userRepository.findById(Math.toIntExact(userId));
        boolean userNotFound = user.isEmpty();
        if (userNotFound) {
            return ResponseEntity.status(404).body(new ResponseCommonDTO("User not found"));
        }

        try {
            User deletedUser = user.get();
            deletedUser.setStatus(false);
            this.userRepository.save(deletedUser);
            return ResponseEntity.ok().body(new ResponseCommonDTO("User deleted with success"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ResponseCommonDTO("An error occurred while deleting the user"));
        }
    }
}