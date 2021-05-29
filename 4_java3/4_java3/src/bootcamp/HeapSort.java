package bootcamp;

import java.util.Comparator;

// Java program for implementation of Heap Sort
public class HeapSort  <T> implements  Sorter<T>{

    @Override
    public void sort(T arr[], Comparator<T> c) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, c);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0, c);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static <T> void heapify(T arr[], int n, int i, Comparator<T> c)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && c.compare(arr[l], arr[largest])>0)
            largest = l;

        // If right child is larger than largest so far
        if (r < n && c.compare(arr[r], arr[largest])>0)
            largest = r;

        // If largest is not root
        if (largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest, c);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(Integer arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[])
    {
        Integer arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;

        HeapSort ob = new HeapSort();
        Comparator<Integer> c1 = (a, b)->a-b;
        ob.sort(arr, c1);
//        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
