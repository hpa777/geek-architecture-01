package ru.geekbrains.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    private HttpResponse() {
    }

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

    private Map<String, String> headers;

    private String body;

    private STATUS status;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("HTTP/1.1 %d %s%n", status.getCode(), status.getMessage()));
        headers.forEach((k, v) -> result.append(String.format("%s: %s%n", k, v)));
        result.append("\n");
        result.append(body);
        return result.toString();
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {

        private final HttpResponse httpResponse;

        private Builder() {
            this.httpResponse = new HttpResponse();
        }

        public Builder withHeaders(Map<String, String> headers) {
            this.httpResponse.headers = headers;
            return this;
        }

        public Builder withBody(String body) {
            this.httpResponse.body = body;
            return this;
        }

        public Builder withStatus(STATUS status) {
            this.httpResponse.status = status;
            return this;
        }

        public HttpResponse build() {
            if (this.httpResponse.headers == null) {
                this.httpResponse.headers = new HashMap<>();
                this.httpResponse.headers.put("Content-Type", "text/html; charset=utf-8");
            }
            return this.httpResponse;
        }
    }
}
