package factory;

import java.util.Comparator;

public class QuickSortSorterImple<T> implements Sorter<T>{

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        int n = arr.length;
        quickSort(arr, 0, n - 1, c);
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition(T[] arr, int low, int high, Comparator<T> c) {

        T pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller, pivot
            if (c.compare(arr[j], pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private void quickSort(T[] arr, int startIndex, int endIndex, Comparator<T> c) {
        if (startIndex < endIndex) {
            int pi = partition(arr, startIndex, endIndex, c);
            quickSort(arr, startIndex, pi - 1, c);
            quickSort(arr, pi + 1, endIndex, c);
        }
    }
}
