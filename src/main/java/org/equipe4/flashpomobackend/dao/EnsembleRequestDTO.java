package org.equipe4.flashpomobackend.dao;

import org.equipe4.flashpomobackend.models.User;

public record EnsembleRequestDTO(Long ensembleId, String name, String description, User user) {
}
