package PracticoTarde;

import java.util.Comparator;

public class HeapSort<T> implements Sorter<T> {

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, c, n, i);
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify root element
            heapify(arr, c, i, 0);
        }
    }

    public void heapify(T arr[],Comparator<T> c,  int n, int i) {
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

            heapify(arr, c, n, largest);
        }
    }

}
