package org.punkdomus.runecraftacademy.infra.repository;

import org.punkdomus.runecraftacademy.data.models.Ensemble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnsembleRepository extends JpaRepository<Ensemble, UUID> {
}
