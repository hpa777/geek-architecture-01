package ru.geekbrains.services;

import ru.geekbrains.domain.HttpResponse;

public interface ResponseSerializer {

    String serialize(HttpResponse response);
}
