package ir.snapppay.bankingservice.service;

import ir.snapppay.bankingservice.payload.request.AccountBalanceReq;
import ir.snapppay.bankingservice.payload.request.CardInquiryReq;
import ir.snapppay.bankingservice.payload.request.CardMoneyTransferReq;
import ir.snapppay.bankingservice.payload.response.AccountBalanceRes;
import ir.snapppay.bankingservice.payload.response.CardInquiryRes;
import ir.snapppay.bankingservice.payload.response.CardMoneyTransferRes;

public interface BankingService {

    CardInquiryRes cardInquiry(CardInquiryReq cardInquiryReq);

    CardMoneyTransferRes cardMoneyTransfer(CardMoneyTransferReq cardMoneyTransferReq);

    AccountBalanceRes accountBalance(AccountBalanceReq accountBalanceReq);
}
