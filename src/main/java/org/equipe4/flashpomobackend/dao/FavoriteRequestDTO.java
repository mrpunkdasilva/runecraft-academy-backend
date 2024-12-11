package org.equipe4.flashpomobackend.dao;

public record FavoriteRequestDTO(Long farvoriteId, String favoritationDateTimestamp, boolean status, int userId) {
}
