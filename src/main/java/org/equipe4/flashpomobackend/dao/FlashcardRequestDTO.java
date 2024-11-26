package org.equipe4.flashpomobackend.dao;

import org.equipe4.flashpomobackend.models.Ensemble;

public record FlashcardRequestDTO(Long flashcardId, String title, String content, String createdAt, String updatedAt, Ensemble ensembleId ) {
}
