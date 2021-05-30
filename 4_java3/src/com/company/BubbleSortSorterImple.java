package com.company;

import java.util.Comparator;

public class BubbleSortSorterImple<T> implements Sorter<T>{

    @Override
    public void sort(T[] arr, Comparator<T> comparator) {
        bubbleSort(arr, comparator);
    }

    private void bubbleSort(T[] arr, Comparator<T> comparator) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (comparator.compare(arr[j], arr[j+1]) < 0) //arr[j] > arr[j+1]
                {
                    // swap arr[j+1] and arr[j]
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

}
