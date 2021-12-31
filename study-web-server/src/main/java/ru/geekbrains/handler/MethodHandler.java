package ru.geekbrains.handler;

import ru.geekbrains.domain.HTTP_STATUS;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.services.FileService;

public abstract class MethodHandler {

    protected final FileService fileService;

    private final String method;

    private final MethodHandler next;

    protected MethodHandler(FileService fileService, String method, MethodHandler next) {
        this.fileService = fileService;
        this.method = method;
        this.next = next;
    }

    public HttpResponse handle(HttpRequest request) {
        HttpResponse response;
        if (method.equals(request.getMethod())) {
            response = handleInternal(request);
        } else if (next != null) {
            response = next.handle(request);
        } else {
            response = HttpResponse.createBuilder()
                    .withBody("<h1>Метод не поддерживается!</h1>")
                    .withStatus(HTTP_STATUS.METHOD_NOT_ALLOWED)
                    .build();
        }
        return response;
    }

    protected abstract HttpResponse handleInternal(HttpRequest request);
}
