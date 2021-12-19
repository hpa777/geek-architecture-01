package ru.geekbrains.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Deque;
import java.util.LinkedList;

class SocketServiceImpl implements SocketService{

    private final Socket socket;

    SocketServiceImpl(Socket socket) {
        this.socket = socket;
    }

    @Override
    public Deque<String> readRequest() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream(), StandardCharsets.UTF_8));

            while (!input.ready());

            Deque<String> request = new LinkedList<>();
            while (input.ready()) {
                String line = input.readLine();
                System.out.println(line);
                request.add(line);
            }
            return request;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void writeResponse(String rawResponse) {
        try {
            PrintWriter output = new PrintWriter(socket.getOutputStream());
            output.print(rawResponse);
            output.flush();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws IOException {
        if (!socket.isClosed()) {
            socket.close();
        }
    }
}
