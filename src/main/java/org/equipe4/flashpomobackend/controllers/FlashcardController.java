package org.equipe4.flashpomobackend.controllers;

import org.equipe4.flashpomobackend.dao.FlashcardRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/flashcards")
public class FlashcardController {

//    @Autowired
//    private  FlashcardRepository flashcardRepository;

    //PEGAR OS FLASHCARD
    @GetMapping("/")
    public ResponseEntity getAllFlashcards() {
        return ResponseEntity.ok().build();
    }
    //PEGAR UM UNICO FLASHCARD
    @GetMapping("/{flashcardId}")
    public ResponseEntity getFlashcardById(@PathVariable Long flashcardId) {
        return ResponseEntity.ok().build();
    }

    //CRIAR FLASHCARD
    @PostMapping("/")
    public ResponseEntity createFlashcard(@RequestBody FlashcardRequestDTO body){
        return ResponseEntity.ok().build();
    }

    //EDITAR
    @PutMapping("/{flashcardId}")
    public ResponseEntity updateFlashcard(@RequestBody FlashcardRequestDTO flashcard, @PathVariable Long flashcardId){
        return ResponseEntity.ok().build();
    }

    //DELETAR
    @DeleteMapping("/{flashcardId}")
    public ResponseEntity deleteFlashcard(@PathVariable("flashcard") Long flashcardId){
        return ResponseEntity.ok().build();
    }
}
