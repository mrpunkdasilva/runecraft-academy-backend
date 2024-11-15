package org.equipe4.flashpomobackend.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * The Flashcard class represents a flashcard entity in the application.
 * It is annotated with Lombok annotations for generating getters, setters, constructors, and other boilerplate code.
 * The class is also annotated as an entity, indicating that it maps to a database table.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "FLASHCARD")
public class Flashcard {
    /**
     * The unique identifier of the flashcard, which is the primary key.
     * It is generated automatically using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FLASHCARD_ID")
    private Integer flashcardId;

    /**
     * The title of the flashcard.
     */
    @Column(name = "TITLE", length = 150)
    private String title;

    /**
     * The content of the flashcard.
     */
    @Column(name = "CONTENT", columnDefinition = "TEXT")
    private String content;

    /**
     * The timestamp when the flashcard was created.
     */
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    /**
     * The timestamp when the flashcard was last updated.
     */
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    /**
     * The ensemble that the flashcard belongs to.
     * This is a many-to-one relationship, where one ensemble can have multiple flashcards.
     */
    @ManyToOne
    @JoinColumn(name = "ENSEMBLE_ID")
    private Ensemble ensemble;
}