package ir.snapppay.bankingservice.payload.request;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardMoneyTransferReq extends BaseReq {
    private String anything2;
}
