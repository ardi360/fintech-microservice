package ir.snapppay.bankingservice.repository;

import ir.snapppay.bankingservice.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    Optional<PersonEntity> findTopByOrderById();
}
