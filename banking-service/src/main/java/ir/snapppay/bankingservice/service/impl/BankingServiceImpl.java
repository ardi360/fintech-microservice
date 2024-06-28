package ir.snapppay.bankingservice.service.impl;

import ir.snapppay.bankingservice.constant.CallingResult;
import ir.snapppay.bankingservice.domain.AccountEntity;
import ir.snapppay.bankingservice.payload.request.AccountBalanceReq;
import ir.snapppay.bankingservice.payload.request.CardInquiryReq;
import ir.snapppay.bankingservice.payload.request.CardMoneyTransferReq;
import ir.snapppay.bankingservice.payload.response.AccountBalanceRes;
import ir.snapppay.bankingservice.payload.response.CardInquiryRes;
import ir.snapppay.bankingservice.payload.response.CardMoneyTransferRes;
import ir.snapppay.bankingservice.repository.AccountRepository;
import ir.snapppay.bankingservice.service.BankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankingServiceImpl implements BankingService {
    private final AccountRepository accountRepository;

    @Override
    public CardInquiryRes cardInquiry(CardInquiryReq cardInquiryReq) {
        return null;
    }

    @Override
    public CardMoneyTransferRes cardMoneyTransfer(CardMoneyTransferReq cardMoneyTransferReq) {
        return null;
    }

    @Override
    public AccountBalanceRes accountBalance(AccountBalanceReq accountBalanceReq) {
        Optional<AccountEntity> firstByAccountNumber = accountRepository.findFirstByAccountNumber(accountBalanceReq.getAccountNumber());
        if (firstByAccountNumber.isPresent()) {
            return AccountBalanceRes.builder()
                    .balance(firstByAccountNumber.get().getBalance())
                    .resultCode(CallingResult.SUCCESS.getCode())
                    .description(CallingResult.SUCCESS.getDescription())
                    .build();
        }
        return AccountBalanceRes.builder()
                .resultCode(CallingResult.ACCOUNT_NOT_FOUND.getCode())
                .description(CallingResult.ACCOUNT_NOT_FOUND.getDescription())
                .build();
    }
}
