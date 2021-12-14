package ru.geekbrains;

import ru.geekbrains.config.Config;
import ru.geekbrains.config.ConfigFactory;

public class Main {

    public static void main(String[] args) {
        Config config = ConfigFactory.create(args);
        WebServer.configWebServer()
                .createFileService(config.getWwwHome())
                .createRequestParser()
                .createResponseMaker()
                .setPort(config.getPort())
                .config()
                .start();
    }
}
