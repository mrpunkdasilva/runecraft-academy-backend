package org.punkdomus.runecraftacademy.dao;

public record BoxRequestDTO(Long boxId, int price, String title, byte[] cover, String description, boolean status, int userId) {

}
