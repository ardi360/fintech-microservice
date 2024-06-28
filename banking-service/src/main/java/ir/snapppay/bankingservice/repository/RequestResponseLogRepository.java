package ir.snapppay.bankingservice.repository;

import ir.snapppay.bankingservice.domain.RequestResponseLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestResponseLogRepository extends JpaRepository<RequestResponseLogEntity, Long> {
}
