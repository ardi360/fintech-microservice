package ir.snapppay.bankingservice.constant;

public enum Status {
    ACTIVE("active"),
    NOT_ACTIVE("not_active"),
    BLOCKED("blocked");

    private final String value;

    Status(String value) {
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
