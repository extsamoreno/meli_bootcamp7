package com.company;

import java.util.Comparator;

public class BubbleSortSorterImple <T> implements Sorter <T> {

    @Override
    public void sort(T[] arr, Comparator<T> cmp) {
        bubbleSort(arr, cmp);
    }

    private void bubbleSort(T[] arr, Comparator<T> cmp) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (cmp.compare(arr[j], arr[j+1]) > 0)
                {
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
}
