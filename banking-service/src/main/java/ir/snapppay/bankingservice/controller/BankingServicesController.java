package ir.snapppay.bankingservice.controller;

import ir.snapppay.bankingservice.payload.request.CardInquiryReq;
import ir.snapppay.bankingservice.payload.response.CardInquiryRes;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BankingServicesController {
    //todo : dont forget to add swagger for api documenting as per requested later after all things done!

    @PostMapping("/card/inquiry")
//    @PreAuthorize("hasAnyAuthority('SCOPE_card.inquiry')")
    public ResponseEntity<CardInquiryRes> cardInquiry(@RequestBody @Valid CardInquiryReq cardInquiryReq, HttpServletRequest request) {
        return null;
    }

    @PostMapping("/card/money-transfer")
//    @PreAuthorize("hasAnyAuthority('SCOPE_card.money-transfer')")
    public String test1() {
        return "test";
    }

    @PostMapping("/account/balance")
//    @PreAuthorize("hasAnyAuthority('SCOPE_card.balance')")
    public String test2() {
        return "test";
    }

    //... other CRUD apis or we can pass it to Spring Data Rest module to do it for us !! greeeeat
}
