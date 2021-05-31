package SaveTheRopaSA;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        GuardaRopa gr = new GuardaRopa();
        List<Prenda> listado = new ArrayList<>();
        Prenda p1 = new Prenda("Nike","35A-32");
        Prenda p2 = new Prenda("Addidas","3B4-32");

        listado.add(p1);
        listado.add(p2);

        Integer ticket = gr.guardarPrendas(listado);

        gr.mostrarPrendas();

        System.out.println("Se devolvio este listado de ropa: " + gr.devolverPrendas(ticket));

        gr.mostrarPrendas();

    }
}
