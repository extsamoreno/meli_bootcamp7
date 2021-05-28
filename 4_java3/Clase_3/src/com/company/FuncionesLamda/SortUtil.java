package com.company.FuncionesLamda;

import java.util.Comparator;

public class SortUtil {

    public static <T> void ordenar(T arr[], Comparator<T> comparador){
        for (int i = 0; i < arr.length; i++) {
            for (int j= 0; j < arr.length-1; j++) {
                if(comparador.compare(arr[j],arr[j+1])>0){
                    T tmp =  arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;

                }
            }

        }
    }
}
