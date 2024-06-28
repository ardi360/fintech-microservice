package ir.snapppay.bankingservice.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.snapppay.bankingservice.constant.TransferPossibility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardInquiryRes extends BaseRes {
    private String destinationCardOwnerFirstName;

    private String destinationCardOwnerLastName;

    private TransferPossibility transferPossibility;
}
