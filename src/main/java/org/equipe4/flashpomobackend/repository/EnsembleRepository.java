package org.equipe4.flashpomobackend.repository;

import org.equipe4.flashpomobackend.models.Ensemble;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Ensemble entities.
 * This interface extends JpaRepository to provide CRUD operations and other database functionalities for Ensemble objects.
 *
 * @param <Ensemble> the type of entity to be managed, in this case, Ensemble
 * @param <Integer> the type of the entity's primary key, in this case, Integer
 */
public interface EnsembleRepository extends JpaRepository<Ensemble, Integer> {

}
