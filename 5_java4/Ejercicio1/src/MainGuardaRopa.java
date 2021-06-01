import java.util.ArrayList;
import java.util.List;

public class MainGuardaRopa {

    public static void main(String[] args) {
        {
            Prenda prenda1 = new Prenda("Nike", "ModeloB");
            Prenda prenda2 = new Prenda("Adidas", "ModeloA");
            List<Prenda> list1 = new ArrayList<>();
            list1.add(prenda1);
            list1.add(prenda2);

            Prenda prenda3 = new Prenda("Puma", "ModeloC");
            Prenda prenda4 = new Prenda("VS", "ModeloZ");
            List<Prenda> list2 = new ArrayList<>();
            list2.add(prenda3);
            list2.add(prenda4);

            GuardaRopa guardaRopa = new GuardaRopa();
            guardaRopa.guardarPrenda(list1);
            guardaRopa.guardarPrenda(list2);

            guardaRopa.mostrarPrenda();

            guardaRopa.devolverPrenda(1);

            guardaRopa.mostrarPrenda();


        }
    }
}
