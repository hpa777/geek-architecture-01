package ru.geekbrains.handler;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.services.RequestParser;
import ru.geekbrains.services.ResponseSerializer;
import ru.geekbrains.services.SocketService;

import java.io.IOException;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;

    private final RequestParser requestParser;

    private final MethodHandler methodHandler;

    private final ResponseSerializer responseSerializer;

    public RequestHandler(SocketService socketService, RequestParser requestParser, MethodHandler methodHandler, ResponseSerializer responseSerializer) {
        this.socketService = socketService;
        this.requestParser = requestParser;
        this.methodHandler = methodHandler;
        this.responseSerializer = responseSerializer;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parseRequest(rawRequest);

        HttpResponse response = methodHandler.handle(httpRequest);
        socketService.writeResponse(responseSerializer.serialize(response));

        try {
            socketService.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Client disconnected!");
    }
}
