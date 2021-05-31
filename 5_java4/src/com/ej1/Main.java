package com.ej1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    var campera = new Campera("Columbia","antifiro3");
	    var remera = new Remera("Mike","Drifi");

	    var guardaRopa = new GuardaRopa();
        System.out.println("Codigo guardado: " + guardaRopa.guardarPrendas(new ArrayList<Prenda>(List.of(campera,remera))));

        guardaRopa.mostrarPrendas();

        guardaRopa.devolverPrendas(1);
        guardaRopa.mostrarPrendas();

    }
}
