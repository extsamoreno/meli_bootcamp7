package com.company;

import java.util.Comparator;

public class HeapSortSorterImple<T> implements Sorter<T> {

    @Override
    public void sort(T[] arr, Comparator<T> compa) {
        // Ejecuta el metodo heapsort
        heapSort(arr, compa);
    }

    // ORDENAMIENTO HEAPSORT
    private void heapSort(T[] arr, Comparator<T> compa) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, compa);

        for (int i = n - 1; i > 0; i--) {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0, compa);
        }
    };

    private void heapify(T[] arr, int n, int i, Comparator<T> compa)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && compa.compare(arr[l], arr[largest]) > 0)
            largest = l;

        if (r < n && compa.compare(arr[r], arr[largest]) > 0)
            largest = r;

        if (largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest, compa);
        }
    }
}
