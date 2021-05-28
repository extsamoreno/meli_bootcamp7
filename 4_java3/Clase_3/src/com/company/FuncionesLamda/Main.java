package com.company.FuncionesLamda;

import java.util.Comparator;

public class Main<T> {

    public static void main(String[] args) {
        Integer arr[] ={3,4,53,2,32,4,4};
        mostrarArreglo(arr);
        SortUtil.ordenar(arr,new ComparatorIntAsc() );
        mostrarArreglo(arr);

        String arrS[] ={"Juan","Pedro","Maria","Armando"};
        mostrarArreglo(arrS);
        SortUtil.ordenar(arrS,new ComparetoStringAsc());
        mostrarArreglo(arrS);

        Comparator<String>Funcion = (o1,n2)->o1.compareTo(n2);
        mostrarArreglo(arrS);
        SortUtil.ordenar(arrS,Funcion);
        mostrarArreglo(arrS);

        Integer arr2[] ={3,4,53,2,32,4,4};
        Comparator<Integer>Funcion2 = (a,b)->b-a;
        SortUtil.ordenar(arr2,Funcion2);
        mostrarArreglo(arr2);


        mostrarArreglo(arrS);
        SortUtil.ordenar(arrS, (o1,n2)->o1.compareTo(n2));
        mostrarArreglo(arrS);
    }

    public static <T> void mostrarArreglo(T[] arr){
            for(T num:arr){
                System.out.print(num+" ");

            }
        System.out.println();
    }
}
