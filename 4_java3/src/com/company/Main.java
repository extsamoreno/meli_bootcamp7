package com.company;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args){

        try {
            Persona p1 = new Persona("tavo1", 4);
            Persona p2 = new Persona("tavo2", 1);
            Persona p3 = new Persona("tavo3", 2);
            Persona p4 = new Persona("tavo4", 0);

            Celular c1 = new Celular(41234, "ztavo");
            Celular c2 = new Celular(11234, "atavo");
            Celular c3 = new Celular(21234, "etavo");
            Celular c4 = new Celular(21234, "jtavo");
            Celular c5 = new Celular(21234, "ctavo");

            Persona[] arr1 = {p1, p2, p3, p4};
            Celular[] arr2 = {c1, c2, c3, c4, c5};

            SortUtil.ordenar(arr1);
            SortUtil.ordenar(arr2);

            for (int i = 0; i < arr1.length; i++) {
                System.out.print(arr1[i].toString() + "\n");
            }
            System.out.println("\n");
            for (int i = 0; i < arr2.length; i++) {
                System.out.print(arr2[i].toString() + "\n");
            }


            Object pepe = MiFactory.getInstance("aaa");

            Sorter s = (Sorter) MiFactory.getInstance("sorter");

            Integer[] iArr = {5,4,3,2,2,1};
            Comparator<Integer> criterio = (a,b) -> a-b;
            s.sort(iArr,criterio);

            for (int i = 0; i < iArr.length; i++) {
                System.out.println(+ iArr[i]);
            }


        } catch (IOException | ClassNotFoundException ex){
           ex.printStackTrace();
        }

    }
}

