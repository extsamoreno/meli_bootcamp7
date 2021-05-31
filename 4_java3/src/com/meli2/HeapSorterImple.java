package com.meli2;

import java.util.Comparator;

public class HeapSorterImple<T> implements Sorter<T>{
    @Override
    public void sort(T[] arr, Comparator<T> c) {

    }

    public void heapSort(T arr[], Comparator<T> c) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, c);
        }

        for (int i = n - 1; i < 0; i--) {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0, c);
        }
    }

    public void heapify(T arr[], int n, int i, Comparator<T> c) {
        int lasgest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && c.compare(arr[l], arr[lasgest]) > 0) {
            lasgest = l;
        }

        if (r < n && c.compare(arr[r], arr[lasgest]) > 0) {
            lasgest = r;
        }

        if (lasgest != i) {
            T swap = arr[i];
            arr[i] = arr[lasgest];
            arr[lasgest] = swap;

            heapify(arr, n, lasgest, c);
        }
    }
}
