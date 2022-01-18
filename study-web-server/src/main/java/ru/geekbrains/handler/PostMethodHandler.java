package ru.geekbrains.handler;

import ru.geekbrains.domain.HTTP_STATUS;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.services.FileService;
import ru.geekbrains.services.ResponseSerializer;
import ru.geekbrains.services.SocketService;

@Handler(order = 1, method = "POST")
public class PostMethodHandler extends MethodHandler {


    public PostMethodHandler(FileService fileService, String method, MethodHandler next) {
        super(fileService, method, next);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return HttpResponse.createBuilder()
                .withBody("POST OK")
                .withStatus(HTTP_STATUS.OK)
                .build();
    }
}
