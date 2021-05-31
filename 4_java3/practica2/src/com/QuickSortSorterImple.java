package com;

import java.util.Comparator;

public class QuickSortSorterImple<T> implements Sorter<T> {

    @Override
    public void sort(T[] arr, Comparator<T> compa) {
        //Ejecuta el metodo quickSort
        quickSort(arr, 0, arr.length - 1, compa);
    }

    /**
     * ORDENAMIENTO QUICKSORT
     * Consta de tres partes:
     * - Un metodo para hacer la particion del array
     * - Un metodo para intercambiar los valores entre dos casillas del array
     * - Metodo nucleo que es recursivo y requiere previamente la particion
     **/

    // Metodo para intercambiar los valores entre dos casillas de un array
    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Metodo para hacer la particion del array
    private int partition(T[] arr, int low, int high, Comparator<T> compa) {
        T pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (compa.compare(arr[j], pivot) <= 0) {
                i++;
                swap(arr, i, j);  // intercambiar casillas
            }
        }
        swap(arr, i + 1, high);  // intercambiar casillas
        return (i + 1);
    }

    // Metodo recursivo
    private void quickSort(T[] arr, int low, int high, Comparator<T> cmp) {
        if (low < high) {
            int pi = partition(arr, low, high, cmp);    // Crea la particion de un array

            quickSort(arr, low, pi - 1, cmp);   // Ordenamiento en la izquierda
            quickSort(arr, pi + 1, high, cmp);  // Ordenamiento en la derecha
        }
    }
}
