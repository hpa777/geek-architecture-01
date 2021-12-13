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
        return new HttpResponse(
                null,
                "<h1>Файл не найден!</h1>",
                HttpResponse.STATUS.NOT_FOUND);
    }

    public HttpResponse makeNotAllowed() {
        return new HttpResponse(
                null,
                "<h1>Метод не поддерживается!</h1>",
                HttpResponse.STATUS.METHOD_NOT_ALLOWED);
    }

    public HttpResponse makeContent(String content) {
        return new HttpResponse(null, content, HttpResponse.STATUS.OK);
    }
}
