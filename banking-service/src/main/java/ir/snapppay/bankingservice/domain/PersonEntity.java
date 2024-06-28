package ir.snapppay.bankingservice.domain;

import ir.snapppay.bankingservice.constant.PersonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

//assume each real person (legal or natural) can have many accounts in our bank
// @Data should not be used because it includes @ToString, which can cause issues with lazy loading. The @ToString annotation generates a toString() method that includes all fields, which can trigger lazy loading when we don’t want it to.
// using custom @ToString to exclude lazy-loaded fields.
// @Builder can conflict with JPA's constructor requirements
// @EqualsAndHashCode can cause problem if the entity is not persisted yet !!!
@Entity(name = "person")
@ToString(exclude = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private PersonType personType;

    private String email;

    @Column(nullable = false, unique = true)
    private String nationalCode;

    @Column(nullable = false, unique = true)
    private String cif;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<AccountEntity> accounts;
}
