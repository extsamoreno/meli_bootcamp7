package com.ejercicios2;

import java.util.Comparator;

public class QuickSortSorterImple<T> implements Sorter<T> {
    @Override
    public void sort(T[] arr, Comparator<T> c) {
        quicksort(arr, 0, arr.length - 1, c);
    }

    private static <T> void swap(T[] arr, int i, int j)
    {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static <T> int partition(T[] arr, int low, int high,Comparator<T> c)
    {
        T pivot = arr[high];

        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            if (c.compare(pivot, arr[j]) > 0)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private static <T> void quicksort(T[] arr, int low, int high, Comparator<T> c)
    {
        if (low < high)
        {

            int pi = partition(arr, low, high, c);

            quicksort(arr, low, pi - 1, c);
            quicksort(arr, pi + 1, high, c);
        }
    }

}



