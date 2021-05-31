package saveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class MainRopa {

    public static void main(String[] args) {

        GuardaRopa ropa = new GuardaRopa();
        Prenda prenda1 = new Prenda("Adidas", "Pantalon");
        Prenda prenda2 = new Prenda("Nike", "Pantalon");

        List<Prenda> prendas = new ArrayList<Prenda>();
        prendas.add(prenda1);
        prendas.add(prenda2);

        ropa.guardarPrendas(prendas);
        ropa.guardarPrendas(prendas);

        ropa.mostrarPrendas();
        List<Prenda> prendasVuelta = ropa.devolverPrendas(1);

        System.out.println(prendasVuelta);

        ropa.mostrarPrendas();

    }
}
