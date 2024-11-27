package org.equipe4.flashpomobackend.controllers;

import org.equipe4.flashpomobackend.dao.EnsembleRequestDTO;
import org.equipe4.flashpomobackend.repository.EnsembleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling Ensemble-related HTTP requests.
 */
@RestController
@RequestMapping(value="/ensemble")
public class EnsembleController {

    @Autowired
    private EnsembleRepository ensembleRepository;


    /**
     * Retrieves all ensembles.
     *
     * @return ResponseEntity containing a list of all ensembles or an appropriate status code
     */
    @GetMapping("/")
    public ResponseEntity getAllEnsembles() {
        return ResponseEntity.ok().build();
    }


     /**
     * Retrieves a specific ensemble by its ID.
     *
     * @param ensembleId the ID of the ensemble to retrieve
     * @return ResponseEntity containing the requested ensemble or an appropriate status code
     */
    @GetMapping("/{ensembleId}")
    public ResponseEntity getEnsembleById(@PathVariable Long ensembleId) {
        return ResponseEntity.ok().build();
    }


    /**
     * Creates a new ensemble.
     *
     * @param body the EnsembleRequestDTO containing the ensemble data to be created
     * @return ResponseEntity containing the created ensemble or an appropriate status code
     */
    @PostMapping("/")
    public ResponseEntity createEnsemble(@RequestBody EnsembleRequestDTO body) {
        return ResponseEntity.ok().build();
    }


     /**
     * Updates an existing ensemble.
     *
     * @param ensembleId the ID of the ensemble to update
     * @param body the EnsembleRequestDTO containing the updated ensemble data
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
