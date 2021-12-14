package ru.geekbrains.domain;

import java.util.Map;

public class HttpRequest {

    private String method;

    private String url;

    private Map<String, String> headers;

    private String body;

    public HttpRequest() {

    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {

        private final HttpRequest request;

        private Builder() {
            this.request = new HttpRequest();
        }

        public Builder withMethod(String method) {
            this.request.method = method;
            return this;
        }

        public Builder withUrl(String url) {
            this.request.url = url;
            return this;
        }

        public Builder withBody(String body) {
            this.request.body = body;
            return this;
        }

        public Builder withHeaders(Map<String, String> headers) {
            this.request.headers = headers;
            return this;
        }

        public HttpRequest build() {
            return this.request;
        }
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                '}';
    }
}
