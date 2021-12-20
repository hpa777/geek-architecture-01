package ru.geekbrains.composite;

public class Main {

    public static void main(String[] args) {
        Component root = new Directory(".root");
        root.add(new File("1.txt"));
        root.add(new File("2.txt"));
        Component sub = new Directory(".subdir");
        sub.add(new File("3.txt"));
        sub.add(new File("4.txt"));
        root.add(sub);
        root.display();
    }
}
