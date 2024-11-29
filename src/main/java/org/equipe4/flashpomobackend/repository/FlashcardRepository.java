package org.equipe4.flashpomobackend.repository;

import org.equipe4.flashpomobackend.models.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This interface represents a repository for managing Flashcard entities in the database.
 * It extends the JpaRepository interface provided by Spring Data JPA, which provides
 * basic CRUD (Create, Read, Update, Delete) operations and additional query methods.
 *
 * @since 1.0
 */
@Repository
public interface FlashcardRepository extends JpaRepository<Flashcard, Integer> {
    Optional<Flashcard> findById(Integer id);
     List<Flashcard> findByEnsembleId(Integer ensemble);
}
