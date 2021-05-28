package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona("Juan", 100);
        Persona persona2 = new Persona("Juana", 101);
        Persona persona3 = new Persona("Juano", 99);
        Precedable<Persona>[] arr = new Precedable[3];
        arr[0] = persona1;
        arr[1] = persona2;
        arr[2] = persona3;
        SortUtil.ordenar(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }



    }
}
