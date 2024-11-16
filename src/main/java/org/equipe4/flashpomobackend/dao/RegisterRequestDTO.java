package org.equipe4.flashpomobackend.dao;

/**
 * The RegisterRequestDTO class is a data transfer object (DTO) that represents the registration request data.
 * It contains the name, email, password, and avatar fields for the user's registration information.
 * The class also has a constructor that allows creating an instance without the avatar field.
 *
 * @author Your Name
 */
public record RegisterRequestDTO(String name, String email, String password, byte[] avatar) {
    /**
     * Constructs a RegisterRequestDTO instance without the avatar field.
     *
     * @param name     the name of the user
     * @param email    the email of the user
     * @param password the password of the user
     */
    public RegisterRequestDTO(String name, String email, String password) {
        this(name, email, password, null);
    }
}