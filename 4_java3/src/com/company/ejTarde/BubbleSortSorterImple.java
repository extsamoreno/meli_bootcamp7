package com.company.ejTarde;

import java.util.Comparator;

public class BubbleSortSorterImple <T> implements  Sorter<T> {

    @Override
    public void sort(T[] arr, Comparator<T> c) {

        int n = arr.length;

        for(int i = 0 ; i < n-1 ; i++) {
            for(int j = 0 ; j < n-i-1 ; j++) {
                T o1 = arr[j+1];
                T o2 = arr[j];
                if(c.compare(o1, o2) < 0) {
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }

}
