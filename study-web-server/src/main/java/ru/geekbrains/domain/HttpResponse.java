package ru.geekbrains.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    private HttpResponse() {
    }

    private Map<String, String> headers;

    private String body;

    private HTTP_STATUS HTTPStatus;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public HTTP_STATUS getHTTPStatus() {
        return HTTPStatus;
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
