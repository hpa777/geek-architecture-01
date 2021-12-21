package ru.geekbrains.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements Component{

    private final List<Component> children = new ArrayList<>();

    private final String name;

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println(this.name);
        children.forEach(component -> component.display());
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }
}
