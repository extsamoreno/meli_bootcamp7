package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona("Juan", 100);
        Persona persona2 = new Persona("Juana", 101);
        Persona persona3 = new Persona("Juano", 99);

        Celular celular1 = new Celular(3000, "Juan");
        Celular celular2 = new Celular(1000, "Juana");
        Celular celular3 = new Celular(2000, "Juano");

        Precedable<Persona>[] arr = new Precedable[3];
        arr[0] = persona1;
        arr[1] = persona2;
        arr[2] = persona3;

        Precedable<Celular>[] arrCel = new Precedable[3];
        arrCel[0] = celular1;
        arrCel[1] = celular2;
        arrCel[2] = celular3;

        SortUtil.ordenar(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }

        SortUtil.ordenar(arrCel);
        for (int i = 0; i < arrCel.length; i++) {
            System.out.println(arrCel[i].toString());
        }

    }
}
