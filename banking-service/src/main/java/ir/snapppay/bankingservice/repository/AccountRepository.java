package ir.snapppay.bankingservice.repository;

import ir.snapppay.bankingservice.domain.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findFirstByAccountNumber(String accountNumber);
}
