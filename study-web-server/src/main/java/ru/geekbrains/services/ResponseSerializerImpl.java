package ru.geekbrains.services;

import ru.geekbrains.domain.HTTP_STATUS;
import ru.geekbrains.domain.HttpResponse;


class ResponseSerializerImpl implements ResponseSerializer{
    @Override
    public String serialize(HttpResponse response) {
        StringBuilder result = new StringBuilder();
        HTTP_STATUS status = response.getHTTPStatus();
        result.append(String.format("HTTP/1.1 %d %s%n", status.getCode(), status.getMessage()));
        response.getHeaders().forEach((k, v) -> result.append(String.format("%s: %s%n", k, v)));
        result.append("\n");
        result.append(response.getBody());
        return result.toString();
    }
}
