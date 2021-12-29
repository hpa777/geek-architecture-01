package ru.geekbrains.visitor;

public interface Animal {

    public void accept(AnimalOperation operation);
}
