package ru.geekbrains.strategy;

public class BubbleSortStrategy implements SortStrategy{

    @Override
    public int[] sort(int[] dataset) {

        for (int i = 0; i < dataset.length; i++) {
            int max = 0;
            int mi = 0;
            int j;
            for (j = 0; j < dataset.length - i; j++) {
                if (dataset[j] > max) {
                    max = dataset[j];
                    mi = j;
                }
            }
            j--;
            dataset[mi] = dataset[j];
            dataset[j] = max;
        }
        return dataset;
    }
}
