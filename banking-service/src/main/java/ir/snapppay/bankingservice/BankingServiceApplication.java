package ir.snapppay.bankingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingServiceApplication {
// todo : add secret header checker later in the end to prevent out of api gateway calling
    public static void main(String[] args) {
        SpringApplication.run(BankingServiceApplication.class, args);
    }
}
