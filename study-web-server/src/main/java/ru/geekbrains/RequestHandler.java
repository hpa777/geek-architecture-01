package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.services.RequestParser;
import ru.geekbrains.services.SocketService;

import java.io.IOException;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;
    private final FileService fileService;
    private final RequestParser requestParser;
    private final ResponseMaker responseMaker;

    public RequestHandler(SocketService socketService, RequestParser requestParser, FileService fileService, ResponseMaker responseMaker) {
        this.socketService = socketService;
        this.requestParser = requestParser;
        this.fileService = fileService;
        this.responseMaker = responseMaker;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parseRequest(rawRequest);

        String fileContent = fileService.getFileContent(httpRequest.getUrl());
        HttpResponse response = responseMaker.makeHttpResponse(fileContent, httpRequest.getMethod());

        socketService.writeResponse(response.toString());
        try {
            socketService.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("Client disconnected!");
    }
}
