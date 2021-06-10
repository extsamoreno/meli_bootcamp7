package com.meli.socialmeli.service.util;

import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.model.User;

import java.util.Comparator;
import java.util.Date;

public class QuickSort{
    public static final Comparator<String> string_asc= (a,b) -> a.compareTo(b);
    public static final Comparator<String> string_des= (a,b) -> b.compareTo(a);
    public static final Comparator<Date> date_asc= (a,b) -> a.compareTo(b);
    public static final Comparator<Date> date_des= (a,b) -> b.compareTo(a);
    public void sortPostByDate(Post[] arr, Comparator<Date> c) {
        quicksortDate(arr,c,0,arr.length-1);
    }
    public void sortUserByName(User[] arr, Comparator<String> c){quicksortName(arr,c,0, arr.length-1);};

    public void quicksortDate(Post[] arr, Comparator<Date> c, int izq, int der){

        Post pivote=arr[izq]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la busqueda de izquierda a derecha
        int j=der;         // j realiza la busqueda de derecha a izquierda
        Post aux;

        while(i < j){                          // mientras no se crucen las busquedas
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
            quicksortDate(arr,c,izq,j-1);          // ordenamos subarray izquierdo
        if(j+1 < der)
            quicksortDate(arr,c,j+1,der);          // ordenamos subarray derecho

    }

    public void quicksortName(User[] arr, Comparator<String> c, int izq, int der){

        User pivote=arr[izq]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la busqueda de izquierda a derecha
        int j=der;         // j realiza la busqueda de derecha a izquierda
        User aux;

        while(i < j){                          // mientras no se crucen las busquedas
            while(c.compare(arr[i].getUserName(), pivote.getUserName()) <=0 && i < j) i++; // busca elemento mayor que pivote
            while(c.compare(arr[j].getUserName(), pivote.getUserName())>0) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux= arr[i];                      // los intercambia
                arr[i]=arr[j];
                arr[j]=aux;
            }
        }

        arr[izq]=arr[j];      // se coloca el pivote en su lugar de forma que tendremos
        arr[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

        if(izq < j-1)
            quicksortName(arr,c,izq,j-1);          // ordenamos subarray izquierdo
        if(j+1 < der)
            quicksortName(arr,c,j+1,der);          // ordenamos subarray derecho

    }
}
