package ir.snapppay.bankingservice.service.impl;

import ir.snapppay.bankingservice.payload.request.AccountBalanceReq;
import ir.snapppay.bankingservice.payload.request.CardInquiryReq;
import ir.snapppay.bankingservice.payload.request.CardMoneyTransferReq;
import ir.snapppay.bankingservice.payload.response.AccountBalanceRes;
import ir.snapppay.bankingservice.payload.response.CardInquiryRes;
import ir.snapppay.bankingservice.payload.response.CardMoneyTransferRes;
import ir.snapppay.bankingservice.service.BankingService;
import org.springframework.stereotype.Service;

@Service
public class BankingServiceImpl implements BankingService {
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
        return null;
    }
}
