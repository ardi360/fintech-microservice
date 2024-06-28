package ir.snapppay.bankingservice.constant;

public enum TransferPossibility {

    ALLOWED("allowed"),
    NOT_ALLOWED("not_allowed");

    private final String value;

    TransferPossibility(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
