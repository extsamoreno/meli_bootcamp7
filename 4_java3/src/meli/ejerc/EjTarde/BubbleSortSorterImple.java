package meli.ejerc.EjTarde;

import meli.ejerc.Ej1.Precedable;

import java.util.Comparator;

public class BubbleSortSorterImple<T> implements Sorter<T> {

    @Override
    public String toString() {
        return "BubbleSort";
    }

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (c.compare(arr[j + 1], arr[j]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j +1] = temp;
                }
    }
}

