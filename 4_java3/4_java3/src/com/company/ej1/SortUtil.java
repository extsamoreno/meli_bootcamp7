package com.company.ej1;

public class SortUtil {

    public static <T> void ordenar(Precedable<T> arr[]) {

        int n = arr.length;

        for(int i = 0 ; i < n-1 ; i++) {
            for(int j = 0 ; j < n-i-1 ; j++) {
                Precedable o1 = arr[j+1];
                Precedable o2 = arr[j];
                if(o1.precedeA(o2) < 0) {
                    Precedable<T> temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }

}
