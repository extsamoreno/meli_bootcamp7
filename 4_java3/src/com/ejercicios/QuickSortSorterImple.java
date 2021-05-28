package com.ejercicios;

import java.util.Comparator;

public class QuickSortSorterImple<T> implements  Sorter<T>{
    @Override
    public void sort(T[] arr, Comparator<T> c) {
        quicksort(arr, c, 0, arr.length - 1);
    }

    public static <T> void quicksort(T A[], Comparator<T> c, int izq, int der) {
        T pivote = A[izq];
        int i=izq;
        int j=der;
        T aux;

        while(i < j){
            while(c.compare(A[i], pivote) <=0 && i < j) i++;
            while(c.compare(A[j], pivote) >0 ) j--;
            if (i < j) {
                aux= A[i];
                A[i]=A[j];
                A[j]=aux;
            }
        }

        A[izq]=A[j];
        A[j]=pivote;

        if(izq < j-1)
            quicksort(A, c,izq,j-1);
        if(j+1 < der)
            quicksort(A,c, j+1,der);

    }


}
