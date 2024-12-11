package org.equipe4.flashpomobackend.repository;

import org.equipe4.flashpomobackend.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
