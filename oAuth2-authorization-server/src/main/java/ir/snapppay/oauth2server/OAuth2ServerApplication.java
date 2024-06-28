package ir.snapppay.oauth2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OAuth2ServerApplication {

    //todo : fetch client details from database not from properties
    //todo : add build docker image profile to all other microservices and complete the docker compose file with all microservices

    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerApplication.class, args);
    }
}
