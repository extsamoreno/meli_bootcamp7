package Parte2;

import Parte1.IPrecedable;

import java.util.Comparator;

public class BurbleSortSorterImple implements Sorter{
    public BurbleSortSorterImple() {
    }

    @Override
    public <T> void sort(T[] arr, Comparator<T> c) {
        for (int j = 0; j < arr.length -1; j++) {
            for (int i = 0; i < arr.length -1; i++) {
                if (c.compare(arr[i], (T) arr[i+1]) > 0) {
                    T menor = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = menor;
                }
            }
        }
    }
}
