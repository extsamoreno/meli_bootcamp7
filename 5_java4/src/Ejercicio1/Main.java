package Ejercicio1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Prenda> listPrenda = new ArrayList<>();

        listPrenda.add(new Prenda("Nike", "2020"));
        listPrenda.add(new Prenda("Oliver", "2017"));

        GuardarRopa guardarRopa = new GuardarRopa();

        guardarRopa.guardarPrendas(listPrenda);
        guardarRopa.guardarPrendas(listPrenda);
        guardarRopa.guardarPrendas(listPrenda);

        guardarRopa.mostrarPrendas();
        guardarRopa.devolverPrendas(1);

    }
}
