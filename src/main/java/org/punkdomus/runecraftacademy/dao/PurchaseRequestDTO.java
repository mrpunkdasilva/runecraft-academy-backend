package org.punkdomus.runecraftacademy.dao;

public record PurchaseRequestDTO(Long purchaseId, String email, String rule, byte[] avatar, String purschaseDate, String status, int amount, int userId) {
}
