package EjerciciosT;

import java.util.Comparator;

public class QuickSortSorterImple implements Sorter {

    @Override
    public void sort(Object[] arr, Comparator c) {

        quickSort(arr, 0, arr.length-1, c);

    }

    static <T> void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static <T> int partition(T[] arr, int low, int high, Comparator<T> c)
    {

        // pivot
        T pivot = arr[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            if (c.compare(arr[j], pivot) > 0)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static <T> void quickSort(T[] arr, int low, int high, Comparator<T> c)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high, c);

            quickSort(arr, low, pi - 1, c);
            quickSort(arr, pi + 1, high, c);
        }
    }
}



