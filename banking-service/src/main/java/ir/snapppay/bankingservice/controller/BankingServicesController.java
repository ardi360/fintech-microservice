package ir.snapppay.bankingservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BankingServicesController {
    // todo : dont forget to add swagger for api documenting as per requested later after all things done!

    @PostMapping("/test")
    @PreAuthorize("hasAnyAuthority('SCOPE_test.test')")
    public String test() {
        return "test";
    }
}
