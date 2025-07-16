package org.punkdomus.runecraftacademy.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * The Purchase class represents a purchase entity in the application.
 * It is annotated with Lombok annotations for generating getters, setters, constructors, and other boilerplate code.
 * The class is also annotated as an entity, indicating that it maps to a database table.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PURCHASE")
public class Purchase {
    /**
     * The unique identifier of the purchase, which is the primary key.
     * It is generated automatically using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PURCHASE_ID")
    private Integer purchaseId;

    /**
     * The timestamp when the purchase was made.
     */
    @Column(name = "PURCHASE_DATE")
    private LocalDateTime purchaseDate;

    /**
     * The status of the purchase, such as "Completed" or "Pending".
     */
    @Column(name = "STATUS", length = 20)
    private String status;

    /**
     * The amount of the purchase.
     */
    @Column(name = "AMOUNT")
    private Integer amount;

    /**
     * The user who made the purchase.
     * This is a many-to-one relationship, where one user can have multiple purchases.
     */
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}