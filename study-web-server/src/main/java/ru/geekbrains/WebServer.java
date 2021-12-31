package ru.geekbrains;



import ru.geekbrains.handler.MethodHandler;
import ru.geekbrains.handler.MethodHandlerFactory;
import ru.geekbrains.handler.RequestHandler;
import ru.geekbrains.services.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {


    private final MethodHandler methodHandler;

    private final RequestParser requestParser;

    private final ResponseSerializer responseSerializer;

    private final int port;

    public WebServer(ru.geekbrains.config.Config config) {
        methodHandler = MethodHandlerFactory.create(FileServiceFactory.create(config.getWwwHome()));
        requestParser = RequestParserFactory.create();
        responseSerializer = ResponseSerializerFactory.create();
        port = config.getPort();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.printf("Server started at port %d!%n", port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                SocketService socketService = SocketServiceFactory.create(socket);

                new Thread(new RequestHandler(
                        socketService,
                        requestParser,
                        methodHandler,
                        responseSerializer)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
