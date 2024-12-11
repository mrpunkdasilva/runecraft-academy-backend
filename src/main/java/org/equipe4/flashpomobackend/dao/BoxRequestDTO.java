package org.equipe4.flashpomobackend.dao;

public record BoxRequestDTO(Long boxId, int price, String title, byte[] cover, String description, boolean status, int userId) {

}
