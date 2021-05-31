package com.company.CT;

import com.company.EjercicioFactori.Comunicador;
import com.company.EjercicioFactori.ComunicadorFactory;

import java.io.IOException;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static <integer> void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {

        Comparator<Integer> c1 = (a,b)->a-b;
       /* Sorter sorter = new QuickSortImple();
        Integer [] quick={1,4,2,6,7,9,3};
        mostrarArreglo(quick);
        sorter.sort(quick,c1);
        mostrarArreglo(quick);

        System.out.println("Heap");
        Sorter sorterH = new HeapSortImple();
        //Integer [] Heap={1,4,2,6,7,9,3};
        Integer [] Heap={ 12, 11, 13, 5, 6, 7 };
        mostrarArreglo(Heap);
        sorterH.sort(Heap,c1);
        mostrarArreglo(Heap);


        System.out.println("Buuble");
        Sorter sorterB = new BubbleSortImple();
        Integer [] Bubble={1,4,2,6,7,9,3};
        mostrarArreglo(Bubble);
        sorterB.sort(Bubble,c1);
        mostrarArreglo(Bubble);

*/


        Integer[] numeros = new Integer[100000];
        Random r = new Random();

        int variable= 100000;
        for (int i = 0; i < numeros.length ; i++) {
            numeros[i]= variable;
            variable=variable-1;
        }


        Time time = new Time();
        time.Iniciar();
        Sorter<Integer> sorter = (Sorter)MiFactory.getInstance("sorter");
        sorter.sort(numeros,c1);
        time.Detener();
        System.out.println("Tiempo transcurrido "+time.elapsedTime()+" Segundos");


    }


    public static <T> void mostrarArreglo(T[] arr){
        for(T num:arr){
            System.out.print(num+" ");

        }
        System.out.println();
    }
}
