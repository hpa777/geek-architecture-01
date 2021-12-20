package ru.geekbrains.services;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;

public interface RequestParser {

    public HttpRequest parseRequest(Deque<String> rawRequest);
}
