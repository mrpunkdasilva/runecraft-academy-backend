package org.punkdomus.runecraftacademy.dao;

public record FlashcardRequestEditDTO(String title, String content, String createdAt, String updatedAt, int ensembleId, boolean status) {
}
