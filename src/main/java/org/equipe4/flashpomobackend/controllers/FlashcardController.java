package org.equipe4.flashpomobackend.controllers;

import lombok.RequiredArgsConstructor;
import org.equipe4.flashpomobackend.dao.*;
import org.equipe4.flashpomobackend.models.Ensemble;
import org.equipe4.flashpomobackend.models.Flashcard;
import org.equipe4.flashpomobackend.models.User;
import org.equipe4.flashpomobackend.repository.EnsembleRepository;
import org.equipe4.flashpomobackend.repository.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @Autowired
    private EnsembleRepository ensembleRepository;

    /**
     * Retrieves all Flashcards from the database.
     *
     * @return A ResponseEntity with status 200 (OK) if successful.
     */
    @GetMapping("/")
    public List<Flashcard> getAllFlashcards() {
      return this.flashcardRepository.findAll();
    }

    /**
     * Retrieves a specific Flashcard by its ID.
     *
     * @param flashcardId The ID of the Flashcard to retrieve.
     * @return A ResponseEntity with status 200 (OK) if successful.
     */
    @GetMapping("/{flashcardId}")
    public ResponseEntity getFlashcardById(@PathVariable int flashcardId) {

        Optional<Flashcard> flashcard = this.flashcardRepository.findById(flashcardId);

        if (flashcard.isPresent()) {
            return ResponseEntity.ok().body(new FlashcardResponseDTO(
                    flashcard.get().getFlashcardId(),
                    flashcard.get().getTitle(),
                    flashcard.get().getContent(),
                    flashcard.get().getCreatedAt(),
                    flashcard.get().getUpdatedAt(),
                    Math.toIntExact(flashcard.get().getEnsemble().getId())
            ));
        }

        return ResponseEntity.status(404).body(new ResponseCommonDTO("Ensemble not found"));
    }

    @GetMapping("/ensemble/{ensemble}")
    public List<Flashcard> getEnsembleById(@PathVariable Long ensemble) {
        return this.flashcardRepository.findByEnsemble(ensemble);
    }


    /**
     * Creates a new Flashcard in the database.
     *
     * @param body The Flashcard data to be created.
     * @return A ResponseEntity with status 200 (OK) if successful.
     */
    @PostMapping("/")
    public ResponseEntity createFlashcard(@RequestBody FlashcardRequestDTO body){

        if (body.title().isBlank()) {
            return ResponseEntity.badRequest().body(new ResponseCommonDTO("Field title is required"));
        }
        if (body.content().isBlank()) {
            return ResponseEntity.badRequest().body(new ResponseCommonDTO("Field content is required"));
        }
        if(body.createdAt().isBlank()){
            return ResponseEntity.badRequest().body(new ResponseCommonDTO("Field createdAt is required"));
        }
        if (body.ensembleId() <= 0) {
            return ResponseEntity.badRequest().body(new ResponseCommonDTO("Field ensembleId is required"));
        }

        // Salvar o flashcard no repositório
        try {
            Flashcard flashcard = new Flashcard();
            flashcard.setTitle(body.title());
            flashcard.setContent(body.content());
            flashcard.setCreatedAt(body.createdAt());

            Optional<Ensemble> ensemble = this.ensembleRepository.findById(body.ensembleId());
            if (ensemble.isEmpty()) {
                return ResponseEntity.badRequest().body(new ResponseCommonDTO("Ensemble not found"));
            }
            flashcard.setEnsemble(ensemble.get());

            flashcard.setStatus(true);
            this.flashcardRepository.save(flashcard);

            return ResponseEntity.ok().body(new FlashcardResponseDTO(
                    flashcard.getFlashcardId(),
                    body.title(),
                    body.updatedAt(),
                    body.content(),
                    body.createdAt(),
                    body.ensembleId()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ResponseCommonDTO("An error occurred while creating the ensemble"));
        }

    }

    /**
     * Updates an existing Flashcard in the database.
     *
     * @param flashcard The updated Flashcard data.
     * @param flashcardId The ID of the Flashcard to update.
     * @return A ResponseEntity with status 200 (OK) if successful.
     */
    @PutMapping("/{flashcardId}")
    public ResponseEntity updateFlashcard(@RequestBody FlashcardRequestEditDTO body, @PathVariable Long flashcardId){

    Optional<Flashcard> flashcard = Optional.ofNullable((Flashcard) this.flashcardRepository.findById(flashcardId).orElse(null));

        if (flashcard.isPresent()) {
            // Verificações
            if (body.title().isBlank()) {
                return ResponseEntity.badRequest().body(new ResponseCommonDTO("Field title is required"));
            }
            if (body.content().isBlank()) {
                return ResponseEntity.badRequest().body(new ResponseCommonDTO("Field content is required"));
            }
            if (body.updatedAt().isBlank()) {
                // ele vai retornar um json com { message: "aqui vai a mensagem" }
                return ResponseEntity.badRequest().body(new ResponseCommonDTO("Field createdAt is required"));
            }
            if (body.ensembleId() <= 0) {
                return ResponseEntity.badRequest().body(new ResponseCommonDTO("Field userId is required"));
            }
            if (body.status()) {
                return ResponseEntity.badRequest().body(new ResponseCommonDTO("Field status is required"));
            }

            // Atualizar o flashcard no repositório
            flashcard.get().setTitle(body.title());
            flashcard.get().setContent(body.content());
            flashcard.get().setUpdatedAt(body.updatedAt());


            Optional<Ensemble> ensemble = this.ensembleRepository.findById(body.ensembleId());
            if (ensemble.isEmpty()) {
                return ResponseEntity.badRequest().body(new ResponseCommonDTO("Ensemble not found"));
            }

            flashcard.get().setEnsemble(ensemble.get());
            ensemble.get().setStatus(true);
            this.ensembleRepository.save(ensemble.get());

            return ResponseEntity.ok().body(new FlashcardResponseDTO(
                    flashcard.get().getFlashcardId(),
                    body.title(),
                    body.updatedAt(),
                    body.content(),
                    body.createdAt(),
                    body.ensembleId()
                ));
        }

        return ResponseEntity.status(404).body(new ResponseCommonDTO("Flashcard not found"));
    }

    /**
     * Deletes a Flashcard from the database.
     *
     * @param flashcardId The ID of the Flashcard to delete.
     * @return A ResponseEntity with status 200 (OK) if successful.
     */
    @DeleteMapping("/{flashcardId}")
    public ResponseEntity deleteFlashcard(@PathVariable("flashcard") Long flashcardId){

         // VERIFICAÇÕES
        if (flashcardId <= 0) {
            return ResponseEntity.badRequest().body(new ResponseCommonDTO("Invalid ensemble ID"));
        }

        Optional<Flashcard> flashcard = Optional.ofNullable((Flashcard) this.flashcardRepository.findById(flashcardId).orElse(null));

        if (flashcard.isPresent()) {
            flashcard.get().setStatus(false);
            this.flashcardRepository.save(flashcard.get());
            return ResponseEntity.ok().body(new ResponseCommonDTO("Flashcard deleted"));
        }

        return ResponseEntity.status(404).body(new ResponseCommonDTO("Flashcard not found"));
    }
}