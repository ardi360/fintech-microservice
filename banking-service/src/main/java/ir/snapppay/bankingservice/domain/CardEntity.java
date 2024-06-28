package ir.snapppay.bankingservice.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity(name = "card")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String pan;

    @Column(nullable = false)
    private String expirationDate;

    private String cvv2;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;
}
