package com.company;

public class Main {

    public static void main(String[] args) {
        Persona[] personas = new Persona[4];
        personas[0] = new Persona("A",12345);
        personas[1] = new Persona("B",32345);
        personas[2] = new Persona("C",22345);
        personas[3] = new Persona("D",42345);

        SortUtil.ordenar(personas);
        for (Persona persona : personas) {
            System.out.println(persona);
        }

        System.out.println();

        Celular[] celulares = new Celular[4];
        celulares[0] = new Celular(1234,"A");
        celulares[1] = new Celular(9321,"B");
        celulares[2] = new Celular(2567,"C");
        celulares[3] = new Celular(5867,"D");

        SortUtil.ordenar(celulares);
        for (Celular celular : celulares) {
            System.out.println(celular);
        }
    }
}

