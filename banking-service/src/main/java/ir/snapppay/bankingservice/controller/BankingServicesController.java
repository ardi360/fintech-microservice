package ir.snapppay.bankingservice.controller;

import ir.snapppay.bankingservice.payload.request.AccountBalanceReq;
import ir.snapppay.bankingservice.payload.request.CardInquiryReq;
import ir.snapppay.bankingservice.payload.request.CardMoneyTransferReq;
import ir.snapppay.bankingservice.payload.response.AccountBalanceRes;
import ir.snapppay.bankingservice.payload.response.CardInquiryRes;
import ir.snapppay.bankingservice.payload.response.CardMoneyTransferRes;
import ir.snapppay.bankingservice.service.BankingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BankingServicesController {
    //todo : dont forget to add swagger for api documenting as per requested later after all things done!
    private final BankingService bankingService;

    @PostMapping("/card/inquiry")
    @PreAuthorize("hasAnyAuthority('SCOPE_card.inquiry')")
    public ResponseEntity<CardInquiryRes> cardInquiry(@RequestBody @Valid CardInquiryReq cardInquiryReq) {
        CardInquiryRes cardInquiryRes = bankingService.cardInquiry(cardInquiryReq);
        return ResponseEntity.ok(cardInquiryRes);
    }

    @PostMapping("/card/money-transfer")
//    @PreAuthorize("hasAnyAuthority('SCOPE_card.money-transfer')")
    public ResponseEntity<CardMoneyTransferRes> cardMoneyTransfer(@RequestBody @Valid CardMoneyTransferReq cardMoneyTransferReq) {
        CardMoneyTransferRes cardMoneyTransferRes = bankingService.cardMoneyTransfer(cardMoneyTransferReq);
        return ResponseEntity.ok(cardMoneyTransferRes);
    }

    @PostMapping("/account/balance")
    @PreAuthorize("hasAnyAuthority('SCOPE_account.balance')")
    public ResponseEntity<AccountBalanceRes> accountBalance(@RequestBody @Valid AccountBalanceReq accountBalanceReq) {
        AccountBalanceRes accountBalanceRes = bankingService.accountBalance(accountBalanceReq);
        return ResponseEntity.ok(accountBalanceRes);
    }

    //... other CRUD apis or we can pass it to Spring Data Rest module to do it for us !! greeeeat
}
