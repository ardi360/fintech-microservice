package ir.snapppay.bankingservice.repository;

import ir.snapppay.bankingservice.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
