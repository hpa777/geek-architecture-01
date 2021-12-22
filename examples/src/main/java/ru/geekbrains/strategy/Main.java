package ru.geekbrains.strategy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] dataset = new int[] {2, 5, 4, 3, 2, 8};
        Sorter sorter = new Sorter(new BubbleSortStrategy());
        System.out.println(Arrays.toString(sorter.sort(dataset)));

        int[] dataset1 = new int[] {2, 5, 4, 3, 2, 8};
        Sorter sorter1 = new Sorter(new QuickSortStrategy());
        System.out.println(Arrays.toString(sorter1.sort(dataset1)));

    }
}
