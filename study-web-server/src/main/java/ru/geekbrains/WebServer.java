package ru.geekbrains;


import ru.geekbrains.services.SocketServiceFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private WebServer() {
    }

    private RequestParser requestParser;

    private ResponseMaker responseMaker;

    private FileService fileService;

    private int port;

    public static Config configWebServer() {
        return new Config();
    }

    public static class Config {

        private final WebServer webServer;

        private Config() {
            this.webServer = new WebServer();
        }

        public Config createFileService(String homeDir) {
            this.webServer.fileService = new FileService(homeDir);
            return this;
        }

        public Config createRequestParser() {
            this.webServer.requestParser = new RequestParser();
            return this;
        }

        public Config createResponseMaker() {
            this.webServer.responseMaker = new ResponseMaker();
            return this;
        }

        public Config setPort(int port) {
            this.webServer.port = port;
            return this;
        }

        public WebServer config() {
            return this.webServer;
        }

    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.printf("Server started at port %d!%n", port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(new RequestHandler(
                        SocketServiceFactory.create(socket),
                        requestParser,
                        fileService,
                        responseMaker)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
