package ir.snapppay.bankingservice.service.impl;

import ir.snapppay.bankingservice.constant.ResponseResult;
import ir.snapppay.bankingservice.constant.Status;
import ir.snapppay.bankingservice.constant.TransferPossibility;
import ir.snapppay.bankingservice.domain.AccountEntity;
import ir.snapppay.bankingservice.domain.CardEntity;
import ir.snapppay.bankingservice.payload.request.AccountBalanceReq;
import ir.snapppay.bankingservice.payload.request.CardInquiryReq;
import ir.snapppay.bankingservice.payload.request.CardMoneyTransferReq;
import ir.snapppay.bankingservice.payload.response.AccountBalanceRes;
import ir.snapppay.bankingservice.payload.response.CardInquiryRes;
import ir.snapppay.bankingservice.payload.response.CardMoneyTransferRes;
import ir.snapppay.bankingservice.repository.AccountRepository;
import ir.snapppay.bankingservice.repository.CardRepository;
import ir.snapppay.bankingservice.service.BankingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankingServiceImpl implements BankingService {
    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;

    @Override
    public CardInquiryRes cardInquiry(CardInquiryReq cardInquiryReq) {
        log.info("Going to fetch cards");
        Optional<CardEntity> sourceCard = cardRepository.findByPan(cardInquiryReq.getSourcePan());
        Optional<CardEntity> destinationCard = cardRepository.findByPan(cardInquiryReq.getDestinationPan());
        if (sourceCard.isEmpty() || destinationCard.isEmpty()) {
            return CardInquiryRes.builder()
                    .resultCode(ResponseResult.CARD_NOT_FOUND.getCode())
                    .description(ResponseResult.CARD_NOT_FOUND.getDescription())
                    .transferPossibility(TransferPossibility.NOT_ALLOWED)
                    .build();
        }
        if (!sourceCard.get().getCardStatus().equals(Status.ACTIVE) || !destinationCard.get().getCardStatus().equals(Status.ACTIVE)) {
            return CardInquiryRes.builder()
                    .resultCode(ResponseResult.CARDS_NOT_ACTIVE.getCode())
                    .description(ResponseResult.CARDS_NOT_ACTIVE.getDescription())
                    .transferPossibility(TransferPossibility.NOT_ALLOWED)
                    .build();
        }
        if (!sourceCard.get().getAccount().getAccountStatus().equals(Status.ACTIVE) || !destinationCard.get().getAccount().getAccountStatus().equals(Status.ACTIVE)) {
            return CardInquiryRes.builder()
                    .resultCode(ResponseResult.ACCOUNTS_NOT_ACTIVE.getCode())
                    .description(ResponseResult.ACCOUNTS_NOT_ACTIVE.getDescription())
                    .transferPossibility(TransferPossibility.NOT_ALLOWED)
                    .build();
        }

        return CardInquiryRes.builder()
                .resultCode(ResponseResult.SUCCESS.getCode())
                .description(ResponseResult.SUCCESS.getDescription())
                .destinationCardOwnerFirstName(destinationCard.get().getAccount().getPerson().getFirstName())
                .destinationCardOwnerLastName(destinationCard.get().getAccount().getPerson().getLastName())
                .transferPossibility(TransferPossibility.ALLOWED)
                .build();
    }

    @Override
    public CardMoneyTransferRes cardMoneyTransfer(CardMoneyTransferReq cardMoneyTransferReq) {
        return null;
    }

    @Override
    public AccountBalanceRes accountBalance(AccountBalanceReq accountBalanceReq) {
        log.info("Going to fetch account");
        Optional<AccountEntity> firstByAccountNumber = accountRepository.findFirstByAccountNumber(accountBalanceReq.getAccountNumber());
        if (firstByAccountNumber.isPresent()) {
            return AccountBalanceRes.builder()
                    .balance(firstByAccountNumber.get().getBalance())
                    .resultCode(ResponseResult.SUCCESS.getCode())
                    .description(ResponseResult.SUCCESS.getDescription())
                    .build();
        }
        return AccountBalanceRes.builder()
                .resultCode(ResponseResult.ACCOUNT_NOT_FOUND.getCode())
                .description(ResponseResult.ACCOUNT_NOT_FOUND.getDescription())
                .build();
    }
}
