package org.punkdomus.runecraftacademy.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "pomodoro_stories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PomodoroStory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Instant startTime;

    @Column(nullable = false)
    private Instant endTime;

    @Column(nullable = false)
    private Integer durationMinutes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PomodoroStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PomodoroSessionType sessionType;

    @Lob
    private String activityDescription;
}
