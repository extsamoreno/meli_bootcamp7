package com.bootcamp;

public class Main {

    public static void main(String[] args) {

        Persona[] personas = new Persona[]{
                new Persona(4),
                new Persona(1),
                new Persona(5),
                new Persona(3),
                new Persona(2),
                new Persona(0)
        };


        SortUtil.ordenar(personas);
        for (Persona persona : personas) {
            System.out.println(persona.getDni());
        }

        Celular[] celulares = new Celular[]{
                new Celular("4"),
                new Celular("1"),
                new Celular("5"),
                new Celular("2"),
                new Celular("3"),
        };

        SortUtil.ordenar(celulares);
        System.out.println();

        for (Celular celular : celulares) {
            System.out.println(celular.getNumero());
        }
    }
}
