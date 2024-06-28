package ir.snapppay.bankingservice.domain;

import ir.snapppay.bankingservice.constant.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "card")
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status cardStatus;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;
}
