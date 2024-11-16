package org.equipe4.flashpomobackend.controllers;

import org.equipe4.flashpomobackend.dao.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The UserController class is a REST controller that handles user-related operations.
 * It provides an endpoint to fetch the user information.
 *
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUser dao;

    /**
     * Retrieves the user information.
     *
     * @return a ResponseEntity containing the success message "User fetched successfully"
     */
    @GetMapping
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("User fetched successfully");
    }
}