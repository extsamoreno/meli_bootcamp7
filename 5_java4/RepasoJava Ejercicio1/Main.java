package RepasoJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda p1 = new Prenda("AAA1", "Marca1");
        Prenda p2 = new Prenda("AAA2", "Marca2");
        Prenda p3 = new Prenda("AAA3", "Marca3");
        ArrayList<Prenda> prendas= new ArrayList<>();
        ArrayList<Prenda> prendas2= new ArrayList<>();

        prendas.add(p1);
        prendas.add(p2);
        prendas.add(p3);

        prendas2.add(p3);
        prendas2.add(p2);
        prendas2.add(p1);


        HashMap<Integer, List<Prenda>> mapPrendas = new HashMap<>();

        GuardaRopa guardaropa = new GuardaRopa(prendas, mapPrendas);

        guardaropa.guardarPrendas(prendas);
        guardaropa.guardarPrendas(prendas2);
        guardaropa.mostarPrendas();

        System.out.println(guardaropa.devolverPrendas(2));

    }
}
