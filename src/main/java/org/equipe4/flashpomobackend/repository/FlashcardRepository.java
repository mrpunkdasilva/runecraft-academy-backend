package org.equipe4.flashpomobackend.repository;

import org.equipe4.flashpomobackend.models.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * This interface represents a repository for managing Flashcard entities in the database.
 * It extends the JpaRepository interface provided by Spring Data JPA, which provides
 * basic CRUD (Create, Read, Update, Delete) operations and additional query methods.
 *
 * @since 1.0
 */
public interface FlashcardRepository extends JpaRepository<Flashcard, Integer> {
    Optional<Object> findById(Long intExact);
     List<Flashcard> findByEnsemble(Long ensemble);
}
