package ru.geekbrains;

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
                .withStatus(HttpResponse.STATUS.NOT_FOUND).build();
    }

    public HttpResponse makeNotAllowed() {
        return HttpResponse.createBuilder()
                .withBody("<h1>Метод не поддерживается!</h1>")
                .withStatus(HttpResponse.STATUS.METHOD_NOT_ALLOWED)
                .build();
    }

    public HttpResponse makeContent(String content) {
        return HttpResponse.createBuilder()
                .withBody(content)
                .withStatus(HttpResponse.STATUS.OK)
                .build();
    }
}
