package com.ejercicios;

public class SortUtil{

    public static <T> void ordenar(Precedable<T> arr[]){
        int i, j;
        Precedable<T> aux;
        for (i = 0; i < arr.length - 1; i++) {
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].precedeA((T)arr[j + 1]) == 1) {
                    aux = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = aux;
                }
            }
        }
    }
}
