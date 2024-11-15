package org.equipe4.flashpomobackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;

/**
 * The User class represents a user entity in the application.
 * It is annotated with Lombok annotations for generating getters, setters, constructors, and other boilerplate code.
 * The class is also annotated as an entity, indicating that it maps to a database table.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USER")
public class User {
    /**
     * The unique identifier of the user, which is the primary key.
     * It is generated automatically using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer userId;

    /**
     * The name of the user.
     */
    @Column(name = "NAME", length = 200)
    private String name;

    /**
     * The password of the user.
     */
    @Column(name = "PASSWORD", length = 90)
    private String password;

    /**
     * The email address of the user, which is unique.
     */
    @Column(name = "EMAIL", length = 150, unique = true)
    private String email;

    /**
     * The role of the user, such as "admin" or "user".
     */
    @Column(name = "ROLE", length = 10)
    private String role;

    /**
     * The avatar image of the user, stored as a byte array.
     */
    @Lob
    @Column(name = "AVATAR")
    private byte[] avatar;

    /**
     * The timestamp when the user was created.
     */
    @Column(name = "CREATED_AT")
    private Timestamp createdAt;

    /**
     * The timestamp when the user was last updated.
     */
    @Column(name = "UPDATED_AT")
    private Timestamp updatedAt;

    /**
     * The status of the user, indicating whether the user is active or not.
     */
    @Column(name = "STATUS")
    private boolean status;
}