package ir.snapppay.bankingservice.domain;

import ir.snapppay.bankingservice.constant.AccountType;
import ir.snapppay.bankingservice.constant.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

//each account may have many debit card attached to it
@Entity(name = "account")
@ToString(exclude = "cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status accountStatus;

    @Column(nullable = false)
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<CardEntity> cards;
}

