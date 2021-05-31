package com.meli2;

import java.util.Comparator;

public class QuickSorterImple<T> implements Sorter<T>{
    @Override
    public void sort(T[] arr, Comparator<T> c) {
        quickSort(arr, 0, arr.length, c);
    }

    private void quickSort(T a[], int izq, int der, Comparator<T> c) {
        T pivote = a[izq];
        int i = izq;
        int d = der;
        T aux;

        while (i < d) {
            while (c.compare(a[i], pivote) <= 0 && i < d) i++;
            while (c.compare(a[d], pivote) > 0) d--;
            if (i < d) {
                aux = a[i];
                a[i] = a[d];
                a[d] = aux;
            }
        }

        a[izq] = a[d];
        a[d] = pivote;

        if (izq < d - 1) {
            quickSort(a, izq, d - 1, c);
        }

        if(d + 1 < der) {
            quickSort(a, d + 1, der, c);
        }
    }
}
