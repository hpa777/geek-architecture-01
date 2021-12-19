package ru.geekbrains.services;

import java.io.Closeable;
import java.util.Deque;

public interface SocketService extends Closeable {

    public Deque<String> readRequest();

    public void writeResponse(String rawResponse);

}
