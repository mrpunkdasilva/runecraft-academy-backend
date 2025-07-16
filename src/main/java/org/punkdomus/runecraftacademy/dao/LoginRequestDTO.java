package org.punkdomus.runecraftacademy.dao;

/**
 * The LoginRequestDTO class is a data transfer object (DTO) that represents the login request data.
 * It contains the email and password fields for the user's login credentials.
 *
 */
public record LoginRequestDTO(String email, String password) {
}