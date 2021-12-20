package ru.geekbrains.domain;

public enum HTTP_STATUS {

    OK("OK", 200),
    NOT_FOUND("NOT_FOUND", 404),
    METHOD_NOT_ALLOWED("METHOD_NOT_ALLOWED", 405);

    private final String message;
    private final Integer code;

    HTTP_STATUS(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
