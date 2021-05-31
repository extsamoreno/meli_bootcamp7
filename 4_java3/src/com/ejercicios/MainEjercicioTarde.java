package com.ejercicios;

import java.util.Comparator;

public class MainEjercicioTarde {

    public static void main(String[] args) {

        /*Sorter quickSort = (Sorter)MiFactory.getInstance("sorter");
        Integer[] arr = {5, 6, 19, 8, 8,89};
        Comparator<Integer> c1 = (a, b)->a - b;
        quickSort.sort(arr, c1);
        mostrarArreglo(arr);

        Sorter heapSort = new HeapSortSorterSimple();
        Integer[] arr2 = {5, 6, 19, 8, 8,89};
        heapSort.sort(arr2, c1);

        mostrarArreglo(arr2);

        Sorter bubbleSort = new BubbleSortSorterImple();
        Integer[] arr3 = {5, 6, 19, 8, 8,89};
        heapSort.sort(arr3, c1);

        mostrarArreglo(arr3);
        */


    }

    private static <T>void mostrarArreglo(T[] arr) {
        System.out.println("");
        for(T num: arr)
            System.out.print(num+" ");
    }
}
