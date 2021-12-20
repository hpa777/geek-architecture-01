package ru.geekbrains.composite;


public class File implements Component{

    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println(this.name);
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }
}
