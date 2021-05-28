package com.ejercitacion.mañana;

public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona("Axel", 39150772);
        Persona persona2 = new Persona("Pepe", 43123045);
        Persona persona3 = new Persona("Maria", 24546543);

	    Persona[] personas = {persona1, persona2, persona3};

	    SortUtil.ordenar(personas);
        for (Persona persona : personas) {
            System.out.println(persona.toString());
        }

        Celular celular1 = new Celular("Axel", 1234);
        Celular celular2 = new Celular("Pepe", 2345);
        Celular celular3 = new Celular("Maria", 3456);

        Celular[] celulares = {celular1, celular2, celular3};

        SortUtil.ordenar(celulares);
        for (Celular celular : celulares) {
            System.out.println(celular.toString());
        }

    }
}
