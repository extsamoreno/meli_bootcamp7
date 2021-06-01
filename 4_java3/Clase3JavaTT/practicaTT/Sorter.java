package com.company.Clase3JavaTT.practicaTT;

import java.util.Comparator;

public interface Sorter<T> {

     public void sort(T arr[], Comparator<T> c);

     // A utility function to swap two elements
     static <T> void swap(T[] arr, int i, int j) {
          T temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
     }

}