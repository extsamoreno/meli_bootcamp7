package tt;

import java.util.Comparator;

public class BubbleSortSorterImple<T> implements Sorter<T> {

    @Override
    public void sort(T[] arr, Comparator<T> comparator) {
        optimizedBubbleSort(arr, comparator);
    }

    public void optimizedBubbleSort(T[] arr, Comparator<T> comparator) {
        int i = 0, n = arr.length;
        boolean swapNeeded = true;
        while (i < n - 1 && swapNeeded) {
            swapNeeded = false;
            for (int j = 1; j < n - i; j++) {
                if (comparator.compare(arr[j - 1], arr[j]) > 0) {
                    T temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swapNeeded = true;
                }
            }
            if (!swapNeeded) {
                break;
            }
            i++;
        }
    }
}
