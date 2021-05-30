package com.company;

import java.util.Comparator;

public class HeapSortSorterImple<T> implements Sorter<T>{

    @Override
    public void sort(T[] arr, Comparator<T> comparator) {
        heapSort(arr, comparator);
    }

    private void heapSort(T arr[], Comparator<T> comparator)
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, comparator);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0, comparator);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private void heapify(T arr[], int n, int i, Comparator<T> comparator)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
        Comparator<Integer> lowerThan = (a, b) -> a < b ? 1 : 0; //Si es menor, retorno 1

        //comparator.compare(arr[j], pivot)
        // If left child is larger than root

        if (lowerThan.compare(l, n) > 0 && comparator.compare(arr[l], arr[largest]) > 0) //(l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (lowerThan.compare(r, n) > 0 && comparator.compare(arr[r], arr[largest]) > 0) //(r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest, comparator);
        }
    }
}
