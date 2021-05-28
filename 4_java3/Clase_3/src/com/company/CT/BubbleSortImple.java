package com.company.CT;

import java.util.Comparator;

public class BubbleSortImple <T> implements Sorter<T>{
    @Override
    public void sort(T[] arr, Comparator<T> c) {
        ordenar(arr,c);
    }

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
