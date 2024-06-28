package ir.snapppay.bankingservice.constant;

public enum ResponseResult {
    SUCCESS(0, "Success"),
    INTERNAL_ERROR(800, "Sry we faced a unknown exception, try again later"),
    ACCOUNT_NOT_FOUND(100, "Account Not Found!"),
    CARD_NOT_FOUND(102, "either source or destination card doest not exist!"),
    CARDS_NOT_ACTIVE(201, "either source or destination card is not active!"),
    ACCOUNTS_NOT_ACTIVE(202, "either source or destination account is not active!"),

    ;

    private final int code;
    private final String description;

    ResponseResult(int code, String description) {
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
