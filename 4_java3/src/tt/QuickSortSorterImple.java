package tt;

import java.util.Comparator;

public class QuickSortSorterImple<T> implements Sorter<T> {
    @Override
    public void sort(T[] arr, Comparator<T> comparator) {
        quickSort(arr, 0, arr.length - 1, comparator);
    }

    // A utility function to swap two elements
    public void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    public int partition(T[] arr, int low, int high, Comparator<T> comparator) {

        // pivot
        T pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (comparator.compare(pivot, arr[j]) > 0) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    public void quickSort(T[] arr, int begin, int end, Comparator<T> comparator) {
        if (begin < end) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, begin, end, comparator);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, begin, pi - 1, comparator);
            quickSort(arr, pi + 1, end, comparator);
        }
    }


}
