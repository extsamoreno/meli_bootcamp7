package SaveTheRopaSA;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Prenda prenda1 = new Pantalon ("Adidas", "Jean");
        Prenda prenda2 = new Pantalon("Adidas", "deportivo");

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(prenda1);
        prendas.add(prenda2);

        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(prendas);
        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrendas(1));

    }
}
