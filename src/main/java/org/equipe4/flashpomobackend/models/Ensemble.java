package org.equipe4.flashpomobackend.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DialectOverride;
import org.hibernate.annotations.Where;

/**
 * The Ensemble class represents an ensemble entity in the application.
 * It is annotated with Lombok annotations for generating getters, setters, constructors, and other boilerplate code.
 * The class is also annotated as an entity, indicating that it maps to a database table.
 */
@Entity
@Table(name = "ENSEMBLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "status = true")
public class Ensemble {
    /**
     * The unique identifier of the ensemble, which is the primary key.
     * It is generated automatically using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

    /**
     * The name of the ensemble.
     */
    private String name;

    /**
     * The description of the ensemble.
     */
    private String description;

    /**
     * The cover image of the ensemble, stored as a byte array.
     */
    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] cover;


    /**
     * The user who owns the box.
     * This is a many-to-one relationship, where one user can own multiple ensembles.
     */
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    private boolean status;
}