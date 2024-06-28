package ir.snapppay.bankingservice.repository;

import ir.snapppay.bankingservice.domain.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
}
