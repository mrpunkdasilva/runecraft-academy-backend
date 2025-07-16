package org.punkdomus.runecraftacademy.dao;

public record FlashcardResponseDTO(Integer flashcardId, String title, String content, String createdAt, String updatedAt, int ensembleId ) {

}
