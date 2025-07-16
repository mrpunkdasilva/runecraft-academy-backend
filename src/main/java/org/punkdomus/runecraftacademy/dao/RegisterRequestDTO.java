package org.punkdomus.runecraftacademy.dao;

/**
 * The RegisterRequestDTO class is a data transfer object (DTO) that represents the registration request data.
 * It contains the name, email, password, and avatar fields for the user's registration information.
 * The class also has a constructor that allows creating an instance without the avatar field.
 *
 * @author Your Name
 */
public record RegisterRequestDTO(String name, String email, String password, byte[] avatar, String createdAt, boolean status,  String role) {

    public RegisterRequestDTO(String name, String email, String password, byte[] avatar, String createdAt, boolean status, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.createdAt = createdAt;
        this.status = true;
        this.role = "client";
    }
}