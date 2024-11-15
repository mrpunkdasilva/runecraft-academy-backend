package org.equipe4.flashpomobackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

/**
 * The LoginSession class represents a login session for a user in the application.
 * It is annotated with Lombok annotations for generating getters, setters, constructors, and other boilerplate code.
 * The class is also annotated as an entity, indicating that it maps to a database table.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "LOGIN_SESSION")
public class LoginSession {
    /**
     * The unique identifier of the login session, which is the primary key.
     * It is generated automatically using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SESSION_ID")
    private Integer sessionId;

    /**
     * The device used by the user to log in, such as a mobile device or a desktop.
     */
    @Column(name = "DEVICE", length = 100)
    private String device;

    /**
     * The timestamp when the user logged in.
     */
    @Column(name = "LOGIN_TIMESTAMP")
    private Timestamp loginTimestamp;

    /**
     * The timestamp when the user logged out.
     */
    @Column(name = "LOGOUT_TIMESTAMP")
    private Timestamp logoutTimestamp;

    /**
     * The IP address of the device used by the user to log in.
     */
    @Column(name = "IP_ADDRESS", length = 255)
    private String ipAddress;

    /**
     * The user associated with the login session.
     * This is a many-to-one relationship, where one user can have multiple login sessions.
     */
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}