package tt;

import java.util.Comparator;

public class QuickSortSorterImple<T> implements Sorter<T> {
    @Override
    public void sort(T[] arr, Comparator<T> comparator) {
        quickSort(arr, 0, arr.length - 1, comparator);
    }

    public void quickSort(T arr[], int begin, int end, Comparator<T> comparator) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end, comparator);

            quickSort(arr, begin, partitionIndex - 1, comparator);
            quickSort(arr, partitionIndex + 1, end, comparator);
        }
    }

    public int partition(T arr[], int begin, int end, Comparator<T> comparator) {
        T pivot = arr[end];
        int i = (begin >0 ) ? (begin - 1) : 0;

        for (int j = begin; j < end; j++) {
            if (comparator.compare(arr[j], pivot) <= 0) {
                i++;

                T swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        T swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }
}
