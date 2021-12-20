package ru.geekbrains.flyweight;

public class Main {

    public static void main(String[] args) {
        TeaMaker teaMaker = new TeaMaker();
        TeaShop teaShop = new TeaShop(teaMaker);

        teaShop.takeOrder("less sugar", 1);
        teaShop.takeOrder("more milk", 2);
        teaShop.takeOrder("without sugar", 5);

        teaShop.serve();
    }
}
