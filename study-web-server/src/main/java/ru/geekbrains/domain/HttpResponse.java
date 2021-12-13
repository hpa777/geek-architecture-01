package ru.geekbrains.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    public enum STATUS {
        OK("OK", 200),
        NOT_FOUND("NOT_FOUND", 404),
        METHOD_NOT_ALLOWED("METHOD_NOT_ALLOWED", 405);

        private final String message;
        private final Integer code;

        STATUS(String message, Integer code) {
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

    private final Map<String, String> headers;

    private final String body;

    private final STATUS status;

    public HttpResponse(Map<String, String> headers, String body, STATUS status) {
        if (headers == null) {
            this.headers = new HashMap<>();
            this.headers.put("Content-Type", "text/html; charset=utf-8");
        } else {
            this.headers = headers;
        }
        this.body = body;
        this.status = status;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("HTTP/1.1 %d %s%n", status.getCode(), status.getMessage()));
        headers.forEach((k, v) -> result.append(String.format("%s: %s%n", k, v)));
        result.append("\n");
        result.append(body);
        return result.toString();
    }
}
