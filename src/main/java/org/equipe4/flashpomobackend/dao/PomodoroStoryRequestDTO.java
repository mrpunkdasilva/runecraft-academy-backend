package org.equipe4.flashpomobackend.dao;

public record PomodoroStoryRequestDTO(Long pomodoroStoryId, String startDateTimestamp, String EndDateTimestamp, int userId) {
}
