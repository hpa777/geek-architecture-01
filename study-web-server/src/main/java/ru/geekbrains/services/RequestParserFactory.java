package ru.geekbrains.services;

public class RequestParserFactory {

    public static RequestParser create() {
        return new RequestParserImpl();
    }
}
