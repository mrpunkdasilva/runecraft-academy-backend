package org.equipe4.flashpomobackend.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * The Favorite class represents a favorite entity in the application.
 * It is annotated with Lombok annotations for generating getters, setters, constructors, and other boilerplate code.
 * The class is also annotated as an entity, indicating that it maps to a database table.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "FAVORITE")
public class Favorite {
    /**
     * The unique identifier of the favorite, which is the primary key.
     * It is generated automatically using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FAVORITE_ID")
    private Integer favoriteId;

    /**
     * The timestamp when the user marked the item as a favorite.
     */
    @Column(name = "FAVORITATION_DATE_TIMESTAMP")
    private LocalDateTime favoritationDate;

    /**
     * The status of the favorite, indicating whether it is active or not.
     */
    @Column(name = "STATUS")
    private Boolean status;

    /**
     * The user who marked the item as a favorite.
     * This is a many-to-one relationship, where one user can have multiple favorites.
     */
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}