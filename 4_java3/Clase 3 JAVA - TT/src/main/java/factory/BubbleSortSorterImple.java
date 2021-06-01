package factory;

import java.util.Comparator;

public class BubbleSortSorterImple <T> implements Sorter<T>{

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        int arrayLength = arr.length;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength - 1; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    T aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
    }
}
