package org.equipe4.flashpomobackend.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * The FlashcardHistoryItem class represents the relationship between flashcard usage history and flashcards.
 * It is a many-to-many relationship table linking flashcards with their usage history.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "FLASHCARD_HISTORY_ITEMS")
public class FlashcardHistoryItem {

    /**
     * The unique identifier for the relationship.
     * This is a composite key consisting of usageHistoryId and flashcardId.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /**
     * The flashcard that is associated with a specific usage history.
     */
    @ManyToOne
    @JoinColumn(name = "FLASHCARD_ID", referencedColumnName = "FLASHCARD_ID", insertable = false, updatable = false)
    private Flashcard flashcard;

    /**
     * The usage history that records the access of the flashcard.
     */
    @ManyToOne
    @JoinColumn(name = "USAGE_HISTORY_ID", referencedColumnName = "USAGE_HISTORY_ID", insertable = false, updatable = false)
    private FlashcardUsageHistory usageHistory;

    // Getters and Setters, Lombok annotations will take care of this if preferred
}