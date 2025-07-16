package org.punkdomus.runecraftacademy.dao;

/**
 * A record representing the data transfer object for user edit requests.
 * This DTO contains the fields that can be updated for a user.
 */
public record UserEditRequestDTO(
    /**
     * The updated name of the user.
     */
    String name,

    /**
     * The updated email address of the user.
     */
    String email,

    /**
     * The updated avatar of the user, represented as a byte array.
     */
    byte[] avatar,

    /**
     * The updated password of the user.
     */
    String password,

    /**
     * The updated role of the user.
     */
    String role,

    /**
     * The timestamp indicating when the user was last updated.
     */
    String updatedAt
) {}