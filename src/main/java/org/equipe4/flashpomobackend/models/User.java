package org.equipe4.flashpomobackend.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

/**
 * The User class represents a user entity in the application.
 * It is annotated with Lombok annotations for generating getters, setters, constructors, and other boilerplate code.
 * The class is also annotated as an entity, indicating that it maps to a database table.
 *
 */
@Entity
@Table(name = "USER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name = "NAME")
    private String name;

    /**
     * The password of the user.
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * The email address of the user.
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * The role of the user, defaults to 'CLIENT'.
     */
    @Column(name = "ROLE")
    @ColumnDefault("'CLIENT'")
    private String role;

    /**
     * The avatar image of the user.
     */
    @Column(name = "AVATAR")
    private byte[] avatar;

    /**
     * The date and time when the user was created.
     */
    @Column(name = "CREATED_AT")
    @ColumnDefault("CURRENT_TIMESTAMP")
    private String createdAt;

    /**
     * The date and time when the user was last updated.
     */
    @Column(name = "UPDATED_AT")
    private String updatedAt;

    /**
     * The status of the user, defaults to true.
     */
    @Column(name = "STATUS")
    @ColumnDefault("true")
    private boolean status;
}