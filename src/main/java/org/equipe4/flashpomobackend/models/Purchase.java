package org.equipe4.flashpomobackend.models;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PURCHASE")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PURCHASE_ID")
    private Integer purchaseId;

    @Column(name = "PURCHASE_DATE")
    private LocalDateTime purchaseDate;

    @Column(name = "STATUS", length = 20)
    private String status;

    @Column(name = "AMOUNT")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
