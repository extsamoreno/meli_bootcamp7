package com.company;

public class SortUtil<T> {
    public static <T> void ordenar(Precedable<T> arr[]) {
        int lengthArray = arr.length;
        Precedable<T> switchVar = null;
        for (int i = 0; i < lengthArray; i++) {
            for (int j = 1; j < (lengthArray - i); j++) {
                if (arr[j - 1].precedeA((T) arr[j]) == 1) {
                    //swap elements
                    switchVar = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = switchVar;
                }

            }
        }
    }
}

//7 - Mientras implemente el metodo Precede a, si