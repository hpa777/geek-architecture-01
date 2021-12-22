package ru.geekbrains.handler;

import ru.geekbrains.domain.HTTP_STATUS;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.services.FileService;
import ru.geekbrains.services.ResponseSerializer;
import ru.geekbrains.services.SocketService;

@Handler(order = 0, method = "GET")
public class GetMethodHandler extends MethodHandler {


    public GetMethodHandler(SocketService socketService, FileService fileService, ResponseSerializer responseSerializer, String method, MethodHandler next) {
        super(socketService, fileService, responseSerializer, method, next);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        String fileContent = fileService.getFileContent(request.getUrl());
        if (fileContent == null) {
            return HttpResponse.createBuilder()
                    .withBody("<h1>Файл не найден!</h1>")
                    .withStatus(HTTP_STATUS.NOT_FOUND).build();
        } else {
            return HttpResponse.createBuilder()
                    .withBody(fileContent)
                    .withStatus(HTTP_STATUS.OK)
                    .build();
        }
    }
}
