package com.meli.act1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    GuardaRopa gr = new GuardaRopa();
        ArrayList<Prenda> array= new ArrayList<Prenda>();
        array.add(new Prenda("Nike","pantalon"));
        array.add(new Prenda("Adidas","remera"));
        gr.guardarPrendas(array);
        gr.guardarPrendas(array);
        gr.mostrarPrendas();

        List<Prenda> casillero = gr.devolverPrendas(1);
        for(Prenda prenda:casillero){
            System.out.println(prenda);
        }

        gr.mostrarPrendas();
    }
}
