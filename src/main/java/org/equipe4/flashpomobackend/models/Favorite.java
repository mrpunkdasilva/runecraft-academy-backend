package org.equipe4.flashpomobackend.models;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "FAVORITE")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FAVORITE_ID")
    private Integer favoriteId;

    @Column(name = "FAVORITATION_DATE_TIMESTAMP")
    private LocalDateTime favoritationDate;

    @Column(name = "STATUS")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
