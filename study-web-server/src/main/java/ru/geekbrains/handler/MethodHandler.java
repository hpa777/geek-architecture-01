package ru.geekbrains.handler;

import ru.geekbrains.domain.HTTP_STATUS;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.services.FileService;
import ru.geekbrains.services.ResponseSerializer;
import ru.geekbrains.services.SocketService;

public abstract class MethodHandler {

    private final SocketService socketService;

    protected final FileService fileService;

    private final ResponseSerializer responseSerializer;

    private final String method;

    private final MethodHandler next;

    protected MethodHandler(SocketService socketService, FileService fileService, ResponseSerializer responseSerializer, String method, MethodHandler next) {
        this.socketService = socketService;
        this.fileService = fileService;
        this.responseSerializer = responseSerializer;
        this.method = method;
        this.next = next;
    }

    public void handle(HttpRequest request) {
        HttpResponse response;
        if (method.equals(request.getMethod())) {
            response = handleInternal(request);
        } else if (next != null) {
            next.handle(request);
            return;
        } else {
            response = HttpResponse.createBuilder()
                    .withBody("<h1>Метод не поддерживается!</h1>")
                    .withStatus(HTTP_STATUS.METHOD_NOT_ALLOWED)
                    .build();
        }
        socketService.writeResponse(responseSerializer.serialize(response));
    }

    protected abstract HttpResponse handleInternal(HttpRequest request);
}
