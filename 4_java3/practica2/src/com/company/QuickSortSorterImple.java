package com.company;

import java.util.Comparator;

public class QuickSortSorterImple <T> implements Sorter <T> {

    @Override
    public void sort(T[] arr, Comparator<T> cmp) {
        quickSort(arr, 0, arr.length-1, cmp);
    }

    int partition(T[] arr, int low, int high, Comparator<T> cmp)
    {
        T pivot = arr[high];

        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {
            if (cmp.compare(arr[j], pivot) <= 0)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    void quickSort(T[] arr, int low, int high, Comparator<T> cmp)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high, cmp);

            quickSort(arr, low, pi - 1, cmp);
            quickSort(arr, pi + 1, high, cmp);
        }
    }

    void swap(T[] arr, int i, int j)
    {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
