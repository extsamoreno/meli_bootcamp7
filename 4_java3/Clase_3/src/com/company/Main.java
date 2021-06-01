package com.company;

import java.io.IOException;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static <integer> void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {

        Comparator<Integer> c1 = (a,b)->a-b;
        Comparator<String> c2 = (o1,o2)->o1.compareTo(o2);
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

        String [] a = new String[9];
        a= new String[]{"Palencia", "Salamanca", "Segovia", "Soria", "Valladolid", "Zamora", "Avila", "Burgos", "León"};

        Sorter<String> sorteString = (Sorter)MiFactory.getInstance("sorter");
        time.Iniciar();
        mostrarArreglo(a);
        sorteString.sort(a,c2);
        time.Detener();
        mostrarArreglo(a);
        System.out.println("Tiempo transcurrido "+time.elapsedTime()+" Segundos");

        System.exit(1);
    }


    public static <T> void mostrarArreglo(T[] arr){
        for(T num:arr){
            System.out.print(num+" ");

        }
        System.out.println();
    }
}
