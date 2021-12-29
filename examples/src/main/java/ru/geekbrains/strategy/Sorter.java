package ru.geekbrains.strategy;

public class Sorter {

    private final SortStrategy sorter;

    public Sorter(SortStrategy sorter) {
        this.sorter = sorter;
    }

    public int[] sort(int[] dataset) {
        return this.sorter.sort(dataset);
    }
}
