package com.company.Clase3JavaTM.Ejercicio1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Precedable<Persona> p1= new Persona("Leandro",25);
        Precedable<Persona> p2= new Persona("Emmanuel",20);
        Precedable<Persona> p3= new Persona("Matias",50);
        Precedable<Persona> p4= new Persona("Cristian",10);
        Precedable<Persona> p5= new Persona("Mabel",18);

        Precedable[] arr= new Persona[5];

        arr[0]=p1;
        arr[1]=p2;
        arr[2]=p3;
        arr[3]=p4;
        arr[4]=p5;

        SortUtil.ordenar(arr);

        Arrays.stream(arr).map(p->p.toString()).forEach(System.out::println);

        Precedable<Celular> c1 = new Celular(1234,"Leandro");
        Precedable<Celular> c2 = new Celular(1235,"Matias");
        Precedable <Celular> c3 = new Celular(1236,"Cruz");

        Precedable[] arrC = new Celular[3];

        arrC[0]=c1;
        arrC[1]=c2;
        arrC[2]=c3;

        SortUtil.ordenar(arrC);

        Arrays.stream(arrC).map(p->p.toString()).forEach(System.out::println);
    }
}
