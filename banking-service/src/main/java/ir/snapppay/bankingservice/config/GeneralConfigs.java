package ir.snapppay.bankingservice.config;

import ir.snapppay.bankingservice.constant.AccountType;
import ir.snapppay.bankingservice.constant.PersonType;
import ir.snapppay.bankingservice.constant.Status;
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

    // populate some test data for database, checks first if we dont have any record. also it only activates on dev profile, also its conditional
    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE)
    @Profile("dev")
    @ConditionalOnProperty(name = "populate.data", havingValue = "true")
    public CommandLineRunner dbDataPopulation() {
        return args -> {
            if (personRepository.findTopByOrderById().isEmpty()) {
                log.info("Populating some data in database");
                PersonEntity samplePerson1 = new PersonEntity();
                samplePerson1.setFirstName("Mohammad");
                samplePerson1.setLastName("Alizade");
                samplePerson1.setEmail("mohammad.alizade@gmail.com");
                samplePerson1.setNationalCode("131451321233");
                samplePerson1.setCif("58123734");
                samplePerson1.setPhoneNumber("091205674321");
                samplePerson1.setPersonType(PersonType.LEGAL);

                AccountEntity sampleAccount1 = new AccountEntity();
                sampleAccount1.setAccountNumber("12349876");
                sampleAccount1.setAccountType(AccountType.CHECKING);
                sampleAccount1.setBalance(1000.0);
                sampleAccount1.setAccountStatus(Status.ACTIVE);
                sampleAccount1.setPerson(samplePerson1);

                samplePerson1.setAccounts(Set.of(sampleAccount1));

                CardEntity sampleCard1 = new CardEntity();
                sampleCard1.setPan("1234567890123456");
                sampleCard1.setExpirationDate("12/24");
                sampleCard1.setCvv2("12345");
                sampleCard1.setCardStatus(Status.ACTIVE);
                sampleCard1.setAccount(sampleAccount1);

                sampleAccount1.setCards(Set.of(sampleCard1));

                personRepository.save(samplePerson1);

                PersonEntity samplePerson2 = new PersonEntity();
                samplePerson2.setFirstName("Parisa");
                samplePerson2.setLastName("Akbari");
                samplePerson2.setEmail("parisa.akbari@gmail.com");
                samplePerson2.setNationalCode("164495421233");
                samplePerson2.setCif("58983764");
                samplePerson2.setPhoneNumber("091285698723");
                samplePerson2.setPersonType(PersonType.NATURAL);

                AccountEntity sampleAccount2 = new AccountEntity();
                sampleAccount2.setAccountNumber("19549315");
                sampleAccount2.setAccountType(AccountType.LOAN);
                sampleAccount2.setBalance(5000.0);
                sampleAccount2.setAccountStatus(Status.ACTIVE);
                sampleAccount2.setPerson(samplePerson2);

                samplePerson2.setAccounts(Set.of(sampleAccount2));

                CardEntity sampleCard2 = new CardEntity();
                sampleCard2.setPan("8764262310123876");
                sampleCard2.setExpirationDate("05/25");
                sampleCard2.setCvv2("54321");
                sampleCard2.setCardStatus(Status.ACTIVE);

                sampleCard2.setAccount(sampleAccount2);

                sampleAccount2.setCards(Set.of(sampleCard2));

                personRepository.save(samplePerson2);
            } else {
                log.info("DB Already Has some data");
            }
        };
    }
}
