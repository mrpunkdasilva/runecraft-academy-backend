package org.equipe4.flashpomobackend.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * The BoxFlashcard class represents the relationship between box and flashcard entities.
 * This is a many-to-many relationship table linking flashcards to boxes.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BOX_FLASHCARD")
public class BoxFlashcard {

    /**
     * The unique identifier for the relationship.
     * This is a composite key consisting of boxId and flashcardId.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /**
     * The flashcard that is associated with a specific box.
     */
    @ManyToOne
    @JoinColumn(name = "FLASHCARD_ID", referencedColumnName = "FLASHCARD_ID", insertable = false, updatable = false)
    private Flashcard flashcard;

    /**
     * The box that contains a specific flashcard.
     */
    @ManyToOne
    @JoinColumn(name = "BOX_ID", referencedColumnName = "BOX_ID", insertable = false, updatable = false)
    private Box box;

    // Getters and Setters, Lombok annotations will take care of this if preferred
}
