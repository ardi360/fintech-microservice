package ir.snapppay.bankingservice.payload.request;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardInquiryReq extends BaseReq {
    private String anything1;
}
