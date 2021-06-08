package com.meli.socialmeli.service.util;

import com.meli.socialmeli.model.Post;

import java.util.Comparator;
import java.util.Date;

public class QuickSort{
    public static final Comparator<String> string_asc= (a,b) -> a.compareTo(b);
    public static final Comparator<String> string_des= (a,b) -> b.compareTo(a);
    public static final Comparator<Date> date_asc= (a,b) -> a.compareTo(b);
    public static final Comparator<Date> date_des= (a,b) -> b.compareTo(a);
    public  void sort(Post[] arr, Comparator<Date> c) {
        quicksort(arr,c,0,arr.length-1);
    }

    public void quicksort(Post[] arr, Comparator<Date> c, int izq, int der){

        Post pivote=arr[izq]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la búsqueda de izquierda a derecha
        int j=der;         // j realiza la búsqueda de derecha a izquierda
        Post aux;

        while(i < j){                          // mientras no se crucen las búsquedas
            while(c.compare(arr[i].getDate(), pivote.getDate()) <=0 && i < j) i++; // busca elemento mayor que pivote
            while(c.compare(arr[j].getDate(), pivote.getDate())>0) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux= arr[i];                      // los intercambia
                arr[i]=arr[j];
                arr[j]=aux;
            }
        }

        arr[izq]=arr[j];      // se coloca el pivote en su lugar de forma que tendremos
        arr[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

        if(izq < j-1)
            quicksort(arr,c,izq,j-1);          // ordenamos subarray izquierdo
        if(j+1 < der)
            quicksort(arr,c,j+1,der);          // ordenamos subarray derecho

    }
}
