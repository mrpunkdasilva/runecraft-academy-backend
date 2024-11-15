package org.equipe4.flashpomobackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class LoginSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SESSION_ID")
    private Integer sessionId;

    @Column(name = "DEVICE", length = 100)
    private String device;

    @Column(name = "LOGIN_TIMESTAMP")
    private Timestamp loginTimestamp;

    @Column(name = "LOGOUT_TIMESTAMP")
    private Timestamp logoutTimestamp;

    @Column(name = "IP_ADDRESS", length = 255)
    private String ipAddress;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
