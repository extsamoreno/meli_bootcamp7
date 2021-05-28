package com.company;

public class Main {

    public static void main(String[] args) {
        Persona p1 = new Persona("juan", 123);
        Persona p2 = new Persona("jose", 124);
        Persona p3 = new Persona("jose", 125);

        Persona[] arr = new Persona[3];
        arr[0] = p3;
        arr[1] = p1;
        arr[2] = p2;

        SortUtil.ordenar(arr);

        System.out.println(arr[0].getDni());
        System.out.println(arr[1].getDni());
        System.out.println(arr[2].getDni());

        Celular c1 = new Celular(1,p1);
        Celular c2 = new Celular(2,p1);
        Celular c3 = new Celular(3,p1);

        Celular[] arr2 = new Celular[3];

        arr2[0] = c1;
        arr2[1] = c3;
        arr2[2] = c2;

        SortUtil.ordenar(arr2);

        System.out.println(arr2[0].getNumero());
        System.out.println(arr2[1].getNumero());
        System.out.println(arr2[2].getNumero());
    }
}
