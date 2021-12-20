package ru.geekbrains.bridge;

public class Main {

    public static void main(String[] args) {

        Theme light = new LightTheme();
        WebPage about = new About();
        about.setTheme(light);
        System.out.println(about.getContent());
    }
}
