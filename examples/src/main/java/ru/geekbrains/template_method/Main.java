package ru.geekbrains.template_method;

public class Main {

    public static void main(String[] args) {
        AndroidBuilder androidBuilder = new AndroidBuilder();
        androidBuilder.build();

        IosBuilder iosBuilder = new IosBuilder();
        iosBuilder.build();
    }
}
