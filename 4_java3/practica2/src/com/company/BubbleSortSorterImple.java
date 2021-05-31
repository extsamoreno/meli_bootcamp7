package com.company;

import java.util.Comparator;

public class BubbleSortSorterImple<T> implements Sorter<T> {

    @Override
    public void sort(T[] arr, Comparator<T> compa) {
        // Ejecuta  bubbleSort
        bubbleSort(arr, compa);
    }

    // ORDENAMIENTO BUBLESORT

    private void bubbleSort(T[] arr, Comparator<T> compa) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (compa.compare(arr[j], arr[j+1]) > 0)
                {
                    // swap arr[j+1] and arr[j]
                    swap(arr, j, j+1);
                }
    };

    // Metodo para intercambiar los valores entre dos casillas de un array
    private void swap(T[] arr, int i, int j)
    {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    };
}
