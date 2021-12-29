package ru.geekbrains.services;

public class ResponseSerializerFactory {

    public static ResponseSerializer create() {
        return new ResponseSerializerImpl();
    }
}
