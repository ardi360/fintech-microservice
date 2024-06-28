package ir.snapppay.bankingservice.payload.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardInquiryReq extends BaseReq {
    @NotEmpty
    private String sourcePan;

    @NotEmpty
    private String destinationPan;
}
