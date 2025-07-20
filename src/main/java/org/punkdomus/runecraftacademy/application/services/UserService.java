package org.punkdomus.runecraftacademy.application.services;

import org.punkdomus.runecraftacademy.data.models.User;

import java.util.UUID;

public interface UserService {
    User registerUser(User user);
    User findUserById(UUID id);
    User findUserByEmail(String email);
}
