package org.equipe4.flashpomobackend.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * The Box class represents a box entity in the application.
 * It is annotated with Lombok annotations for generating getters, setters, constructors, and other boilerplate code.
 * The class is also annotated as an entity, indicating that it maps to a database table.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BOX")
public class Box {
    /**
     * The unique identifier of the box, which is the primary key.
     * It is generated automatically using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOX_ID")
    private Integer boxId;

    /**
     * The price of the box.
     */
    @Column(name = "PRICE")
    private Integer price;

    /**
     * The title of the box.
     */
    @Column(name = "TITLE", length = 120)
    private String title;

    /**
     * The cover image of the box, stored as a byte array.
     */
    @Lob
    @Column(name = "COVER")
    private byte[] cover;

    /**
     * The description of the box.
     */
    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    /**
     * The status of the box, indicating whether it is active or not.
     */
    @Column(name = "STATUS")
    private Boolean status;

    /**
     * The user who owns the box.
     * This is a many-to-one relationship, where one user can own multiple boxes.
     */
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}