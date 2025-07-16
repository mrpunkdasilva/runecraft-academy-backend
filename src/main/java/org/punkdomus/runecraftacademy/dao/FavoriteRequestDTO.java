package org.punkdomus.runecraftacademy.dao;

public record FavoriteRequestDTO(Long farvoriteId, String favoritationDateTimestamp, boolean status, int userId) {
}
