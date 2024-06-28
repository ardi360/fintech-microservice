package ir.snapppay.bankingservice.repository;

import ir.snapppay.bankingservice.domain.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
