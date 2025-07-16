package org.punkdomus.runecraftacademy.controllers;

import lombok.RequiredArgsConstructor;
import org.punkdomus.runecraftacademy.dao.BoxRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/box")
@RequiredArgsConstructor
public class BoxController {

//    @Autowired
//    private BoxRepository boxRepository;

    // PEGAR OS BOXES
    @GetMapping("/")
    public ResponseEntity getAllBoxes() {
        return ResponseEntity.ok().build();
    }

    // PEGAR UM FAVORITO
    @GetMapping("/{boxId}")
    public ResponseEntity getBoxById(@PathVariable Long boxId) {
        return ResponseEntity.ok().build();
    }

    // CRIAR FAVORITO
    @PostMapping("/")
    public ResponseEntity createBox(@RequestBody BoxRequestDTO body) {
        return ResponseEntity.ok().build();
    }

    // EDITAR BOXES
    @PutMapping("/{favoriteId}")
    public ResponseEntity updateBox(@PathVariable("boxId") Long boxId, @RequestBody BoxRequestDTO body) {
        return ResponseEntity.ok().build();
    }

    // DELETAR BOXES
    @DeleteMapping("/{favoriteId}")
    public ResponseEntity deleteBox(@PathVariable("boxId") Long boxId) {
        return ResponseEntity.ok().build();
    }

}
