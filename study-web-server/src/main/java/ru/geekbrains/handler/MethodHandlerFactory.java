package ru.geekbrains.handler;

import org.reflections.Reflections;
import ru.geekbrains.services.FileService;
import ru.geekbrains.services.ResponseSerializer;
import ru.geekbrains.services.SocketService;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Map;

import java.util.TreeMap;


public class MethodHandlerFactory {

    public static MethodHandler create (FileService fileService) {
        Reflections reflections = new Reflections("ru.geekbrains.handler");
        Map<Integer,Class<?>> map = new TreeMap<>(Collections.reverseOrder());
        reflections.getTypesAnnotatedWith(Handler.class).stream().forEach((c)->map.put(c.getAnnotation(Handler.class).order(), c));
        MethodHandler next = null;
        for (Class<?> c : map.values()) {
            String method = c.getAnnotation(Handler.class).method();
            try {
                Constructor constructor = c.getConstructor(FileService.class, String.class, MethodHandler.class);
                next = (MethodHandler) constructor.newInstance(fileService, method, next);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        return next;
    }
}
