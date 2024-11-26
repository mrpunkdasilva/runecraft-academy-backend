package org.equipe4.flashpomobackend.dao;

public record PurchaseRequestDTO(Long purchaseId, String email, String rule, byte[] avatar, String purschaseDate, String status, int amount, int userId) {
}
