package com.meli;

import com.meli.tm.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GuardarRopa guardarRopa = new GuardarRopa();

        Prenda abrigo = new Abrigo("Gucci", "Largo");
        Prenda morral = new Morral("Nike", "Mediano");
        Prenda camiseta = new Camiseta("DG", "Largo");

        List<Prenda> prendasJhader = new ArrayList<>();
        prendasJhader.add(abrigo);
        prendasJhader.add(morral);
        prendasJhader.add(camiseta);
        Integer casilleroJhader = guardarRopa.guardarPrenda(prendasJhader);
        System.out.println("Sus prendas han sido guardadas en el casillero " + casilleroJhader);
        guardarRopa.mostrarPrendas();
        List<Prenda> prendasReclamadas = guardarRopa.devolverPrendas(casilleroJhader);
        guardarRopa.mostrarPrendas();

    }
}
