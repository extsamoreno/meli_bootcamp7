package ejercicio_tarde;

import ejercicio_1.Precedable;

import java.util.Comparator;

public class BubbleSortSorterImple<T> implements Sorter<T> {

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        int[] arregloint = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arregloint[i] = (int) arr[i];
        }
        bubbleSort(arregloint);
        for (int j = 0; j < arr.length; j++) {
            arr[j] = (T) (Object) arregloint[j];
        }
    }

    public void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
}