package com.meli;

import java.nio.file.ClosedWatchServiceException;

public class Main {

    public static void main(String[] args) {
	    Persona persona1 = new Persona("Persona 1", 2234);
	    Persona persona2 = new Persona("Persona 2", 1235);
	    Persona persona3 = new Persona("Persona 3", 7233);

	    Persona[] personas = {persona1, persona2, persona3};

	    SortUtil.ordenar(personas);

        for (int i = 0; i < personas.length; i++) {
            System.out.println(personas[i].getDni());
        }

        Celular celular1 = new Celular(123456, "Titular 1");
        Celular celular2 = new Celular(123486, "Titular 1");
        Celular celular3 = new Celular(193456, "Titular 1");

        Celular[] celulares = {celular1, celular2, celular3};
        SortUtil.ordenar(celulares);
        for (int i = 0; i < celulares.length; i++) {
            System.out.println(celulares[i].getNumero());
        }

        /* Solución Punto 2
        *  1. Se debe realizar en la sobreescritura en cada clase.
        *  2. Si, es mantenible ya que los ajustes se realizaría en la clase donde se desea
        *     ajustar.
        *  3.
        */
    }
}
