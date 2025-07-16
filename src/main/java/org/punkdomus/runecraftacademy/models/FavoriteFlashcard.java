package org.punkdomus.runecraftacademy.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * The FavoriteFlashcard class represents the relationship between favorite and flashcard entities.
 * This is a many-to-many relationship table for linking flashcards to favorites.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "FAVORITE_FLASHCARD")
public class FavoriteFlashcard {

    /**
     * The unique identifier for the relationship.
     * This is a composite key consisting of favoriteId and flashcardId.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /**
     * The ID of the flashcard that is marked as favorite.
     */
    @ManyToOne
    @JoinColumn(name = "FLASHCARD_ID", referencedColumnName = "FLASHCARD_ID", insertable = false, updatable = false)
    private Flashcard flashcard;

    /**
     * The ID of the favorite that is associated with a flashcard.
     */
    @ManyToOne
    @JoinColumn(name = "FAVORITE_ID", referencedColumnName = "FAVORITE_ID", insertable = false, updatable = false)
    private Favorite favorite;

    // Getters and Setters, Lombok annotations will take care of this if preferred
}
