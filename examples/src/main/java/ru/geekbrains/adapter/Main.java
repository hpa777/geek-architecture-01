package ru.geekbrains.adapter;

public class Main {

    public static void main(String[] args) {
        WildDog wildDog = new WildDog();
        Hunter hunter = new Hunter();
        hunter.hunt(new WildDogAdapter(wildDog));
    }
}
