package org.punkdomus.runecraftacademy.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * The FlashcardUsageHistory class represents the usage history of a flashcard by a user.
 * It stores the access date, the associated flashcard, and the user who accessed it.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "FLASHCARD_USAGE_HISTORY")
public class FlashcardUsageHistory {

    /**
     * The unique identifier of the usage history entry.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USAGE_HISTORY_ID")
    private Integer usageHistoryId;

    /**
     * The timestamp when the flashcard was accessed.
     */
    @Column(name = "ACCESS_DATE")
    private LocalDateTime accessDate;

    /**
     * The flashcard that was accessed.
     * This is a many-to-one relationship, as a flashcard can be accessed multiple times.
     */
    @ManyToOne
    @JoinColumn(name = "FLASHCARD_ID", referencedColumnName = "FLASHCARD_ID")
    private Flashcard flashcard;

    /**
     * The user who accessed the flashcard.
     * This is a many-to-one relationship, as a user can access multiple flashcards.
     */
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;
}