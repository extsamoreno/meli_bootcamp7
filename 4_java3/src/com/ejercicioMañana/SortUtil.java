package com.ejercicioMañana;

public class SortUtil {
    public static <T extends Precedable<T>> void ordenar(T[] arr){
        int length = arr.length;
        T temp;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <length-1 ; j++) {
                if (arr[j].precedeA((arr[j+1])) > 0){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
//El método ordenar, ¿puede ordenar un array de cualquier tipo de dato? Si, mientras se tenga un metodo para poder comparar los elementos del array
