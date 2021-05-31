package com.bootcamp;

import java.util.Comparator;

public class BubbleSorterImple<T> implements Sorter<T> {
    @Override
    public void sort(T arr[], Comparator<T> c) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // is left larger than right?
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    // swap j and j + 1
                    T tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
