package org.equipe4.flashpomobackend.models;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BOX")
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOX_ID")
    private Integer boxId;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "TITLE", length = 120)
    private String title;

    @Lob
    @Column(name = "COVER")
    private byte[] cover;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Column(name = "STATUS")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}

