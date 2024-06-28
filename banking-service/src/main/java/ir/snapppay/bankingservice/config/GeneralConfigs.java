package ir.snapppay.bankingservice.config;

import ir.snapppay.bankingservice.constant.AccountType;
import ir.snapppay.bankingservice.constant.PersonType;
import ir.snapppay.bankingservice.domain.AccountEntity;
import ir.snapppay.bankingservice.domain.CardEntity;
import ir.snapppay.bankingservice.domain.PersonEntity;
import ir.snapppay.bankingservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.Set;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class GeneralConfigs {

    private final PersonRepository personRepository;

    // populate some test data for database, checks first if we dont have any record. also it only activates on dev profile
    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE)
    @Profile("dev")
    @ConditionalOnProperty(name = "populate.data", havingValue = "true")
    public CommandLineRunner dbDataPopulation() {
        return args -> {
            if (personRepository.findTopByOrderById().isEmpty()) {
                log.info("Populating some data in database");
                PersonEntity samplePerson = new PersonEntity();
                samplePerson.setFirstName("Mohammad");
                samplePerson.setLastName("Alizade");
                samplePerson.setEmail("mohammad.alizade@gmail.com");
                samplePerson.setNationalCode("131451321233");
                samplePerson.setCif("58123734");
                samplePerson.setPhoneNumber("091205674321");
                samplePerson.setPersonType(PersonType.LEGAL);

                AccountEntity sampleAccount = new AccountEntity();
                sampleAccount.setAccountNumber("12349876");
                sampleAccount.setAccountType(AccountType.CHECKING);
                sampleAccount.setBalance(1000.0);
                sampleAccount.setPerson(samplePerson);

                samplePerson.setAccounts(Set.of(sampleAccount));

                CardEntity sampleCard = new CardEntity();
                sampleCard.setPan("1234567890123456");
                sampleCard.setExpirationDate("12/24");
                sampleCard.setCvv2("12345");
                sampleCard.setAccount(sampleAccount);

                sampleAccount.setCards(Set.of(sampleCard));

                personRepository.save(samplePerson);
            } else {
                log.info("DB Already Has some data");
            }
        };
    }
}
