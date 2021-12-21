package ru.geekbrains.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TeaMaker {

    private final Map<String, KarakTea> availableTea = new HashMap<>();

    public KarakTea make(String preference) {
        if (!availableTea.containsKey(preference)) {
            availableTea.put(preference, new KarakTea());
        }
        return availableTea.get(preference);
    }


}
