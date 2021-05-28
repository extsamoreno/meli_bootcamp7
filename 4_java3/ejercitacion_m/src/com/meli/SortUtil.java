package com.meli;

public class SortUtil {
    public static <T> void ordenar(Precedable<T> arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if(arr[j].precedeA((T)arr[j+1]) > 0) {
                    Precedable<T> temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

//El método ordenar, ¿puede ordenar un array de cualquier tipo de dato? Si, mientras se tenga un metodo para poder comparar los elementos del array
