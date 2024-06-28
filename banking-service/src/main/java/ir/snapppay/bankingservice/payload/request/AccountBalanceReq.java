package ir.snapppay.bankingservice.payload.request;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountBalanceReq extends BaseReq {
    private String accountNumber;
}
