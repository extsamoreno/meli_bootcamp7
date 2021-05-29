package Parte2;

import java.util.Comparator;

public class QuickSortSorterImple implements Sorter {

    public QuickSortSorterImple() {
    }

    @Override
    public <T> void sort(T[] arr, Comparator<T> c) {
        quicksort(arr, 0, arr.length - 1, c);
    }

    public static <T>void quicksort(T A[], int izq, int der, Comparator<T> c) {

        T pivote = A[izq];
        int i=izq;
        int j=der;
        T aux;

        while(i < j){
            while(c.compare(pivote, A[i]) >= 0 && i < j) i++;
            while(c.compare(A[j] , pivote) > 0) j--;
            if (i < j) {
                aux= A[i];
                A[i]=A[j];
                A[j]=aux;
            }
        }

        A[izq]=A[j];
        A[j]=pivote;

        if(izq < j-1)
            quicksort(A,izq,j-1,c);
        if(j+1 < der)
            quicksort(A,j+1,der,c);
    }
}
