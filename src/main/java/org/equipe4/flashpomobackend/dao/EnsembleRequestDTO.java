package org.equipe4.flashpomobackend.dao;

import org.equipe4.flashpomobackend.models.User;

public record EnsembleRequestDTO(String name, String description, int userId) {
}
