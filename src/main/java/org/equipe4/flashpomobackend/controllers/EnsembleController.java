package org.equipe4.flashpomobackend.controllers;


import org.equipe4.flashpomobackend.dao.EnsembleRequestDTO;
import org.equipe4.flashpomobackend.repository.EnsembleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/ensemble")
public class EnsembleController {

    @Autowired
    private EnsembleRepository ensembleRepository;

    // PEGAR OS ENSEMBLES
    @GetMapping("/")
    public ResponseEntity getAllEnsembles() {
        return ResponseEntity.ok().build();
    }

    // PEGAR UM ENSEMBLE
    @GetMapping("/{ensembleId}")
    public ResponseEntity getEnsembleById(@PathVariable Long ensembleId) {
        return ResponseEntity.ok().build();
    }

    // CRIAR ENSEMBLE
    @PostMapping("/")
    public ResponseEntity createEnsemble(@RequestBody EnsembleRequestDTO body) {
        return ResponseEntity.ok().build();
    }

    // EDITAR ENSEMBLES
    @PutMapping("/{ensembleId}")
    public ResponseEntity updateEnsemble(@PathVariable("ensembleId") Long ensembleId, @RequestBody EnsembleRequestDTO body) {
        return ResponseEntity.ok().build();
    }

    // DELETAR ENSEMBLE
    @DeleteMapping("/{ensembleId}")
    public ResponseEntity deleteEnsemble(@PathVariable("ensembleId") Long ensembleId) {
        return ResponseEntity.ok().build();
    }
}
