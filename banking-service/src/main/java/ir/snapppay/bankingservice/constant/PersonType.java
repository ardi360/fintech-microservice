package ir.snapppay.bankingservice.constant;

public enum PersonType {

    LEGAL("LEGAL"),
    NATURAL("NATURAL");

    private final String value;

    PersonType(String value) {
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
