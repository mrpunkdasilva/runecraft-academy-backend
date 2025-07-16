package org.punkdomus.runecraftacademy.repository;

import org.punkdomus.runecraftacademy.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
