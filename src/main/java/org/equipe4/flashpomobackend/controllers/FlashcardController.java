package org.equipe4.flashpomobackend.controllers;

import lombok.RequiredArgsConstructor;
import org.equipe4.flashpomobackend.dao.FlashcardRequestDTO;
import org.equipe4.flashpomobackend.repository.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class is responsible for handling HTTP requests related to Flashcard operations.
 * It uses Spring MVC annotations to map HTTP requests to specific methods.
 */
@RestController
@RequestMapping(value="/flashcard")
@RequiredArgsConstructor
public class FlashcardController {

    @Autowired
    private FlashcardRepository flashcardRepository;

    /**
     * Retrieves all Flashcards from the database.
     *
     * @return A ResponseEntity with status 200 (OK) if successful.
     */
    @GetMapping("/")
    public ResponseEntity getAllFlashcards() {
        return ResponseEntity.ok().build();
    }

    /**
     * Retrieves a specific Flashcard by its ID.
     *
     * @param flashcardId The ID of the Flashcard to retrieve.
     * @return A ResponseEntity with status 200 (OK) if successful.
     */
    @GetMapping("/{flashcardId}")
    public ResponseEntity getFlashcardById(@PathVariable Long flashcardId) {
        return ResponseEntity.ok().build();
    }

    /**
     * Creates a new Flashcard in the database.
     *
     * @param body The Flashcard data to be created.
     * @return A ResponseEntity with status 200 (OK) if successful.
     */
    @PostMapping("/")
    public ResponseEntity createFlashcard(@RequestBody FlashcardRequestDTO body){
        return ResponseEntity.ok().build();
    }

    /**
     * Updates an existing Flashcard in the database.
     *
     * @param flashcard The updated Flashcard data.
     * @param flashcardId The ID of the Flashcard to update.
     * @return A ResponseEntity with status 200 (OK) if successful.
     */
    @PutMapping("/{flashcardId}")
    public ResponseEntity updateFlashcard(@RequestBody FlashcardRequestDTO flashcard, @PathVariable Long flashcardId){
        return ResponseEntity.ok().build();
    }

    /**
     * Deletes a Flashcard from the database.
     *
     * @param flashcardId The ID of the Flashcard to delete.
     * @return A ResponseEntity with status 200 (OK) if successful.
     */
    @DeleteMapping("/{flashcardId}")
    public ResponseEntity deleteFlashcard(@PathVariable("flashcard") Long flashcardId){
        return ResponseEntity.ok().build();
    }
}
