package org.equipe4.flashpomobackend.repository;

import org.equipe4.flashpomobackend.models.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashcardRepository extends JpaRepository<Flashcard, Integer> {
}
