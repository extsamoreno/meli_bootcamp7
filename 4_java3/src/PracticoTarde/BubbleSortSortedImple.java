package PracticoTarde;

import java.util.Comparator;

public class BubbleSortSortedImple<T> implements Sorter<T>{
    @Override
    public void sort(T[] arr, Comparator<T> c) {
        int size = arr.length;

        // loop to access each array element
        for (int i = 0; i < size - 1; i++)

            // loop to compare array elements
            for (int j = 0; j < size - i - 1; j++)

                // compare two adjacent elements
                // change > to < to sort in descending order
                if (c.compare(arr[j], arr[j + 1]) > 0) {

                    // swapping occurs if elements
                    // are not in the intended order
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
}
