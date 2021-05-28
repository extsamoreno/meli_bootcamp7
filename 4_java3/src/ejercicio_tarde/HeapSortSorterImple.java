package ejercicio_tarde;

import java.util.Comparator;

public class HeapSortSorterImple<T> implements Sorter<T> {

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        int[] arregloint = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            arregloint[i] = (int) arr[i];
        }
        heapify(arregloint,0,0);

        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arregloint, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arregloint[0];
            arregloint[0] = arregloint[i];
            arregloint[i] = temp;

            // call max heapify on the reduced heap
            heapify(arregloint, i, 0);
        }
        for (int j=0;j<arr.length;j++){
            arr[j] = (T)(Object)arregloint[j];
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}
