package ir.snapppay.bankingservice.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountBalanceReq extends BaseReq {
    @NotNull
    private String accountNumber;
}
