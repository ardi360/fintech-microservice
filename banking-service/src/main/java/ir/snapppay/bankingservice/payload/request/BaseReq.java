package ir.snapppay.bankingservice.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BaseReq {
    @NotNull
    private Long requestNumber;
}
