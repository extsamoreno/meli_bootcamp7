package com.meli;

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
    }
}
