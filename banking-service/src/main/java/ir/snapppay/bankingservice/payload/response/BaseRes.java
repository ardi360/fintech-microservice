package ir.snapppay.bankingservice.payload.response;

import lombok.Data;

@Data
public class BaseRes {
    private Long resultCode;
    private String description;
}
