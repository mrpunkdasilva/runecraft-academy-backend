package org.punkdomus.runecraftacademy.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * The PurchaseBox class represents the relationship between purchase and box entities.
 * This is a many-to-many relationship table linking boxes to purchases.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PURCHASE_BOX")
public class PurchaseBox {

    /**
     * The unique identifier for the relationship.
     * This is a composite key consisting of purchaseId and boxId.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /**
     * The box that is associated with a specific purchase.
     */
    @ManyToOne
    @JoinColumn(name = "BOX_ID", referencedColumnName = "BOX_ID", insertable = false, updatable = false)
    private Box box;

    /**
     * The purchase that involves a specific box.
     */
    @ManyToOne
    @JoinColumn(name = "PURCHASE_ID", referencedColumnName = "PURCHASE_ID", insertable = false, updatable = false)
    private Purchase purchase;

    // Getters and Setters, Lombok annotations will take care of this if preferred
}
