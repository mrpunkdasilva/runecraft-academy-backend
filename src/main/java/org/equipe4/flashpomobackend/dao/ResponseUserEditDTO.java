package org.equipe4.flashpomobackend.dao;

import lombok.Value;

import java.io.Serializable;

/**
 * The ResponseUserEditDTO class represents the response data for user editing.
 * It contains the updated name, email, and avatar fields.
 */
public record ResponseUserEditDTO(int userId, String name, String email, String password, byte[] avatar, String role) {
}
