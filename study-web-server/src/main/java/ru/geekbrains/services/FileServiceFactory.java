package ru.geekbrains.services;

public class FileServiceFactory {

    public static FileService create(String wwwHome) {
        return new FileServiceImpl(wwwHome);
    }
}
