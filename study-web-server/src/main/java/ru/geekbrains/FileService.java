package ru.geekbrains;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    private final String wwwHome;

    public FileService(String wwwHome) {
        this.wwwHome = wwwHome;
    }

    public String getFileContent(String url) {
        String content = null;
        Path path = Paths.get(this.wwwHome, url);
        if (Files.exists(path)) {
            try {
                content =  Files.readString(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

}
