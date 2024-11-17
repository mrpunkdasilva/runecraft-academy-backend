package org.equipe4.flashpomobackend.dao;

/**
 * The ResponseDTO class is a data transfer object (DTO) that represents the response data.
 * It contains the name and token fields for the user's response information.
 *
 * @author Your Name
 */
public record ResponseDTO(String name, String token) {
}