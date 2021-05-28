package com.company;

public class Main {

    public static void main(String[] args) {
        Persona[] personas = new Persona[4];
        personas[0] = new Persona("Ambar",17628829);
        personas[1] = new Persona("Beto",35283777);
        personas[2] = new Persona("Coki",20456789);
        personas[3] = new Persona("Damian",78456123);
        SortUtil.ordenar(personas);
        for (Persona persona : personas ) {
            System.out.println(persona);
        }

        System.out.println();

        Celular[] celulares = new Celular[4];
        celulares[0] = new Celular(354365317,"Ambar");
        celulares[1] = new Celular(351156987,"Beto");
        celulares[2] = new Celular(011,"Coki");
        celulares[3] = new Celular(01123121545,"Damian");

        SortUtil.ordenar(celulares);
        for (Celular celular : celulares) {
            System.out.println(celular);
        }
    }
    }

