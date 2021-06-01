package ejcio1_save_the_ropa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Prenda prenda = new Prenda("Nike", "Zapatillas");
        Prenda prenda2 = new Prenda("Adidas", "Campera");

        List<Prenda> listaDePrendas1 = new ArrayList<>();
        listaDePrendas1.add(prenda);
        listaDePrendas1.add(prenda2);

        Prenda prenda3 = new Prenda("Topper", "Zapatillas");
        Prenda prenda4 = new Prenda("Gap", "Buzo");

        List<Prenda> listaDePrendas2 = new ArrayList<>();
        listaDePrendas2.add(prenda3);
        listaDePrendas2.add(prenda4);

        System.out.println("\nAlmacenando prendas...");
        int ticket1 = GuardaRopa.guardarPrendas(listaDePrendas1);
        System.out.println("Se han guardado las prendas con el número de ticket " + ticket1);

        int ticket2 = GuardaRopa.guardarPrendas(listaDePrendas2);
        System.out.println("Se han guardado las prendas con el número de ticket " + ticket2);

        System.out.println("\nMostrando todas las prendas guardadas:");
        GuardaRopa.mostrarPrendas();

        System.out.println("\nDevolviendo las prendas asociadas al ticket " + ticket1 + "...");

        try {
            List<Prenda> prendasDevueltas = GuardaRopa.devolverPrendas(ticket1);
            System.out.println("Prendas devueltas correspondientes al ticket " + ticket1 + ": " + prendasDevueltas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
