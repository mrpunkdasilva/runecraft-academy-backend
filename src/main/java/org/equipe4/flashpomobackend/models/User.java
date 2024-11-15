package org.equipe4.flashpomobackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.security.Timestamp;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class User {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "NAME", length = 200)
    private String name;

    @Column(name = "PASSWORD", length = 90)
    private String password;

    @Column(name = "EMAIL", length = 150, unique = true)
    private String email;

    @Column(name = "ROLE", length = 10)
    private String role;

    @Lob
    @Column(name = "AVATAR")
    private byte[] avatar;

    @Column(name = "CREATED_AT")
    private Timestamp createdAt;

    @Column(name = "UPDATED_AT")
    private Timestamp updatedAt;

    @Column(name = "STATUS")
    private boolean status;
}
