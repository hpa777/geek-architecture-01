package ru.geekbrains.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    private HttpResponse() {
    }

    private Map<String, String> headers;

    private String body;

    private HTTP_STATUS HTTPStatus;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("HTTP/1.1 %d %s%n", HTTPStatus.getCode(), HTTPStatus.getMessage()));
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

        public Builder withStatus(HTTP_STATUS HTTPStatus) {
            this.httpResponse.HTTPStatus = HTTPStatus;
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
