package ir.snapppay.billservice.domain;

import jakarta.persistence.Entity;

@Entity(name = "bill")
public class BillEntity {
    private String billId;

    private String paymentId;

    private Long amount;
}
