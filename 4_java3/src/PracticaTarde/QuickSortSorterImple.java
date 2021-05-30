package PracticaTarde;

import java.util.Comparator;

public class QuickSortSorterImple <T> implements Sorter <T> {


    @Override
    public void sort(T[] arr, Comparator<T> comp) {
        quickSort(arr,0,arr.length-1,comp);


    }



    static <T> int partition(T [] arr, int low, int high, Comparator<T> comp)
    {

        T pivot = arr[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            if (comp.compare(arr[j],pivot)<0)
            {

                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static <T> void quickSort(T []arr, int low, int high, Comparator<T> comp)
    {
        if (low < high)
        {

            int pi = partition(arr, low, high,comp);

            quickSort(arr, low, pi - 1, comp);
            quickSort(arr, pi + 1, high, comp);
        }
    }
    static <T> void swap(T[] arr, int i, int j)
    {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}