package com.meli;

import java.util.Comparator;

public class QuickSorterImple <T> implements Sorter<T>{

    @Override
    public void sort(T[] arr, Comparator<T> c) {
        doSort(arr, 0, arr.length - 1, c);
    }

    private <T> void doSort(T[] array, int left, int right, Comparator<T> c) {
        if (left < right) {
            int pivot = partition(array, left, right, c);
            doSort(array, left, pivot - 1, c);
            doSort(array, pivot, right, c);
        }
    }

    private <T> int partition(T[] array, int left, int right, Comparator<T> c) {
        int mid = (left + right) / 2;
        T pivot = array[mid];
        while (right >= left) {
            while (c.compare(array[left],pivot) < 0) {
                left++;
            }
            while (c.compare(pivot,array[right]) < 0) {
                right--;
            }
            if (right >= left) {
                T swap = array[left];
                array[left] = array[right];
                array[right] = swap;
                ++left;
                --right;
            }
        }
        return left;
    }


}
