package ru.geekbrains;

import ru.geekbrains.domain.HTTP_STATUS;
import ru.geekbrains.domain.HttpResponse;

public class ResponseMaker {

    public HttpResponse makeHttpResponse(String content, String method) {
        if (method.equals("GET")) {
            if (content == null) {
                return makeNotFound();
            }
            return makeContent(content);
        }
        return makeNotAllowed();
    }

    public HttpResponse makeNotFound() {
        return HttpResponse.createBuilder()
                .withBody("<h1>Файл не найден!</h1>")
                .withStatus(HTTP_STATUS.NOT_FOUND).build();
    }

    public HttpResponse makeNotAllowed() {
        return HttpResponse.createBuilder()
                .withBody("<h1>Метод не поддерживается!</h1>")
                .withStatus(HTTP_STATUS.METHOD_NOT_ALLOWED)
                .build();
    }

    public HttpResponse makeContent(String content) {
        return HttpResponse.createBuilder()
                .withBody(content)
                .withStatus(HTTP_STATUS.OK)
                .build();
    }
}
