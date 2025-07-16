package org.punkdomus.runecraftacademy.dao;

public record PomodoroStoryRequestDTO(Long pomodoroStoryId, String startDateTimestamp, String EndDateTimestamp, int userId) {
}
