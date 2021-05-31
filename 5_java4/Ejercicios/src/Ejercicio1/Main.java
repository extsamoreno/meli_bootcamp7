package Ejercicio1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda = new Prenda();
        prenda.setMarca("Nike");
        prenda.setModelo("1");

        Prenda prenda2 = new Prenda();
        prenda2.setMarca("Adidas");
        prenda2.setModelo("2");

        Prenda prenda3 = new Prenda();
        prenda3.setMarca("Puma");
        prenda3.setModelo("3");

        ArrayList<Prenda> array = new ArrayList<>();
        array.add(prenda);
        array.add(prenda2);
        array.add(prenda3);

        Prenda prenda4 = new Prenda();
        prenda4.setMarca("Vans");
        prenda4.setModelo("1");

        Prenda prenda5 = new Prenda();
        prenda5.setMarca("Converse");
        prenda5.setModelo("2");

        ArrayList<Prenda> array2 = new ArrayList<>();
        array2.add(prenda4);
        array2.add(prenda5);

        System.out.println(guardaRopa.guardarPrendas(array));
        guardaRopa.guardarPrendas(array2);

        System.out.println(guardaRopa.devolverPrendas(1));
        System.out.println(guardaRopa.devolverPrendas(2));
    }
}
