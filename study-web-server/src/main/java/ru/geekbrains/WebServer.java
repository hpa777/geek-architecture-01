package ru.geekbrains;


import ru.geekbrains.handler.MethodHandlerFactory;
import ru.geekbrains.handler.RequestHandler;
import ru.geekbrains.services.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private WebServer() {
    }


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
            this.webServer.fileService = FileServiceFactory.create(homeDir);
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

            ResponseSerializer responseSerializer = ResponseSerializerFactory.create();

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                SocketService socketService = SocketServiceFactory.create(socket);

                new Thread(new RequestHandler(
                        socketService,
                        RequestParserFactory.create(),
                        MethodHandlerFactory.create(socketService, fileService, responseSerializer)
                        )).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
