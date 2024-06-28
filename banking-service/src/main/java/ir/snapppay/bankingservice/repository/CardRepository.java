package ir.snapppay.bankingservice.repository;

import ir.snapppay.bankingservice.domain.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
    Optional<CardEntity> findByPan(String pan);
}
