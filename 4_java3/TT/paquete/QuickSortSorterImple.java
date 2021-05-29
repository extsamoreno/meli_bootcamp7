package paquete;

import java.util.Comparator;

public class QuickSortSorterImple <T> implements Sorter<T> {

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        quickSort(arr, 0, arr.length -1,c);
    }

    static <T> void swap(T[] arr, int i, int j)
    {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static <T> int partition(T[] arr, int low, int high, Comparator<T> c)
    {
        T pivot = arr[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {
            if (c.compare(arr[j] , pivot) > 0)
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

            quickSort(arr, low, pi - 1,c);
            quickSort(arr, pi + 1, high,c);
        }
    }

    static <T> void printArray(T[] arr, int size)
    {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}
