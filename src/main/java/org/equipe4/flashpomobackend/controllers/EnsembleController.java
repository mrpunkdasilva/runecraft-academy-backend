package org.equipe4.flashpomobackend.controllers;

import lombok.RequiredArgsConstructor;
import org.equipe4.flashpomobackend.dao.EnsembleRequestDTO;
import org.equipe4.flashpomobackend.dao.EnsembleResponseDTO;
import org.equipe4.flashpomobackend.dao.ResponseCommonDTO;
import org.equipe4.flashpomobackend.models.Ensemble;
import org.equipe4.flashpomobackend.repository.EnsembleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controller class for handling Ensemble-related HTTP requests.
 */
@RestController
@RequestMapping(value = "/ensemble")
@RequiredArgsConstructor
public class EnsembleController {

    @Autowired
    private EnsembleRepository ensembleRepository;


    /**
     * Retrieves all ensembles.
     *
     * @return ResponseEntity containing a list of all ensembles or an appropriate status code
     */
    @GetMapping("/")
    public List<Ensemble> getAllEnsembles() {
        return this.ensembleRepository.findAll();
    }


    /**
     * Retrieves a specific ensemble by its ID.
     *
     * @param ensembleId the ID of the ensemble to retrieve
     * @return ResponseEntity containing the requested ensemble or an appropriate status code
     */
    @GetMapping("/{ensembleId}")
    public ResponseEntity getEnsembleById(@PathVariable Long ensembleId) {
        Optional<Ensemble> ensemble = Optional.ofNullable(this.ensembleRepository.findById(ensembleId).orElse(null));

        if (ensemble.isPresent()) {
            return ResponseEntity.ok().body(new EnsembleResponseDTO(
                    ensemble.get().getName(),
                    ensemble.get().getDescription(),
                    ensemble.get().getUser().getUserId()
            ));
        }

        return ResponseEntity.status(404).body(new ResponseCommonDTO("Ensemble not found"));
    }


    /**
     * Creates a new ensemble.
     *
     * @param body the EnsembleRequestDTO containing the ensemble data to be created
     * @return ResponseEntity containing the created ensemble or an appropriate status code
     */
    @PostMapping("/")
    public ResponseEntity createEnsemble(@RequestBody EnsembleRequestDTO body) {
        // Verificações
        if (body.name().isBlank()) {
            return ResponseEntity.badRequest().body(new ResponseCommonDTO("Field name is required"));
        }
        if (body.description().isBlank()) {
            return ResponseEntity.badRequest().body(new ResponseCommonDTO("Field description is required"));
        }
        if (body.user().getUserId() == null || body.user().getUserId() <= 0) {
            return ResponseEntity.badRequest().body(new ResponseCommonDTO("Field userId is required"));
        }

        // Salvar o ensemble no repositório
        try {
            Ensemble ensemble = new Ensemble();
            ensemble.setName(body.name());
            ensemble.setDescription(body.description());
            ensemble.setUser(body.user());
            this.ensembleRepository.save(ensemble);

            return ResponseEntity.ok().body(new EnsembleResponseDTO(
                    body.name(),
                    body.description(),
                    body.user().getUserId()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ResponseCommonDTO("An error occurred while creating the ensemble"));
        }
    }


    /**
     * Updates an existing ensemble.
     *
     * @param ensembleId the ID of the ensemble to update
     * @param body       the EnsembleRequestDTO containing the updated ensemble data
     * @return ResponseEntity containing the updated ensemble or an appropriate status code
     */
    @PutMapping("/{ensembleId}")
    public ResponseEntity updateEnsemble(@PathVariable("ensembleId") Long ensembleId, @RequestBody EnsembleRequestDTO body) {
        return ResponseEntity.ok().build();
    }


    /**
     * Deletes an ensemble.
     *
     * @param ensembleId the ID of the ensemble to delete
     * @return ResponseEntity with an appropriate status code indicating the result of the deletion
     */
    @DeleteMapping("/{ensembleId}")
    public ResponseEntity deleteEnsemble(@PathVariable("ensembleId") Long ensembleId) {
        return ResponseEntity.ok().build();
    }
}
