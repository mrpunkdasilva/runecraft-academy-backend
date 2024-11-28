package org.equipe4.flashpomobackend.dao;

public record FlashcardResponseDTO(Integer flashcardId, String title, String content, String createdAt, String updatedAt, int ensembleId ) {

}
