package org.punkdomus.runecraftacademy.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "favorites")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(FavoriteId.class)
public class Favorite {

    @Id
    @Column(name = "user_id")
    private UUID userId;

    @Id
    @Column(name = "ensemble_id")
    private UUID ensembleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ensemble_id", insertable = false, updatable = false)
    private Ensemble ensemble;

    @CreationTimestamp
    private Instant createdAt;
}
