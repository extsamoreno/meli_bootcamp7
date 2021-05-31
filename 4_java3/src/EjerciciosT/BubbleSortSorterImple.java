package EjerciciosT;

import java.util.Comparator;

public class BubbleSortSorterImple<T> implements Sorter<T> {

    @Override
    public void sort(T[] arr, Comparator<T> c) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {

                if (c.compare(arr[j], arr[j + 1]) < 0) {
                    T aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
    }
}




