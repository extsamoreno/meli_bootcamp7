package com.bootcamp;

import java.util.Comparator;

public class HeapSorterImple<T> implements Sorter<T> {

    @Override
    public void sort(T arr[], Comparator<T> c) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, c);
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify root element
            heapify(arr, i, 0, c);
        }
    }

    void heapify(T arr[], int n, int i, Comparator<T> c) {
        // Find largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && c.compare(arr[l], arr[largest]) > 0)
            largest = l;

        if (r < n && c.compare(arr[r], arr[largest]) > 0)
            largest = r;

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest, c);
        }
    }
}
