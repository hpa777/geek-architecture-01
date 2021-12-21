package ru.geekbrains.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TeaShop {

    private final TeaMaker teaMaker;

    private final Map<Integer, KarakTea> orders = new HashMap<>();

    public TeaShop(TeaMaker teaMaker) {
        this.teaMaker = teaMaker;
    }

    public void takeOrder(String teaType, Integer table) {
        orders.put(table, teaMaker.make(teaType));
    }

    public void serve() {
        orders.forEach((k, v) -> System.out.println("Serving tea to table# " + k));
    }
}
