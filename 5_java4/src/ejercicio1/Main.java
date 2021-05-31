package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> listPrenda = new ArrayList<>();

        listPrenda.add(new Prenda("Nike", "2021") {
        });
        listPrenda.add(new Prenda("Adidas", "2018") {
        });
        listPrenda.add(new Prenda("Puma", "2020") {
        });

        GuardaRopa gr = new GuardaRopa();
        gr.guardarPrendas(listPrenda);
        gr.guardarPrendas(listPrenda);
        gr.guardarPrendas(listPrenda);

        gr.mostrarPrendas();

        gr.devolverPrenda(2);

        gr.mostrarPrendas();
    }
}
