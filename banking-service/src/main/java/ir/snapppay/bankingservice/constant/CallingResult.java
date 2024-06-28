package ir.snapppay.bankingservice.constant;

public enum CallingResult {
    SUCCESS(0, "Success"),
    INTERNAL_ERROR(800, "Sry we faced a unknown exception, try again later"),
    ACCOUNT_NOT_FOUND(100, "Account Not Found!");

    private final int code;
    private final String description;

    CallingResult(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
