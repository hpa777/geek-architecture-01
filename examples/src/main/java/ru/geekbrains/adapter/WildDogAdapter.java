package ru.geekbrains.adapter;

public class WildDogAdapter implements Lion{

    private final WildDog wildDog;

    public WildDogAdapter(WildDog wildDog) {
        this.wildDog = wildDog;
    }

    @Override
    public void roar() {
        this.wildDog.bark();
    }
}
