package ir.snapppay.bankingservice.constant;

public enum AccountType {
    CHECKING("checking"),
    LOAN("loan");

    private final String value;

    AccountType(String value) {
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
