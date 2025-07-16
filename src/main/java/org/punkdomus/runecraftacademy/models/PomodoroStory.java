package org.punkdomus.runecraftacademy.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * The PomodoroStory class represents a user's Pomodoro session history.
 * It stores the start and end timestamps of the Pomodoro sessions.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "POMODORO_STORY")
public class PomodoroStory {

    /**
     * The unique identifier for the Pomodoro story session.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POMODORO_STORY_ID")
    private Integer pomodoroStoryId;

    /**
     * The start timestamp of the Pomodoro session.
     */
    @Column(name = "START_DATE_TIMESTAMP")
    private LocalDateTime startDateTimestamp;

    /**
     * The end timestamp of the Pomodoro session.
     */
    @Column(name = "END_DATE_TIMESTAMP")
    private LocalDateTime endDateTimestamp;

    /**
     * The user who performed the Pomodoro session.
     * This is a many-to-one relationship, where one user can have multiple Pomodoro sessions.
     */
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;
}
