package org.equipe4.flashpomobackend.dao;

public record FlashcardRequestEditDTO(String title, String content, String createdAt, String updatedAt, int ensembleId, boolean status) {
}
