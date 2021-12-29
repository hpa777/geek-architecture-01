package ru.geekbrains.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class StationList implements Iterable<RadioStation> {

    private final List<RadioStation> stations = new ArrayList<>();

    public void addStation(RadioStation station) {
        stations.add(station);
    }

    @Override
    public Iterator<RadioStation> iterator() {
        return new Iterator<RadioStation>() {

            private int count = 0;
            @Override
            public boolean hasNext() {
                return count < stations.size();
            }

            @Override
            public RadioStation next() {
                return stations.get(count++);
            }
        };
    }


}
