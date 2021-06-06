package SaveTheRopa;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GuardarRopa gr = new GuardarRopa();
        ArrayList<Prenda> a1 = new ArrayList<>();

        Prenda p1 = new Prenda("AA","AA01");
        Prenda p2 = new Prenda("AB","AA02");
        a1.add(p1);
        a1.add(p2);

        System.out.println("Sus prendas quedaron guardadas con la clave "+ gr.guardarPrendas(a1));
        System.out.println("Lista de productos "+ gr.devolverPrendas(1));

        ArrayList<Prenda> a2 = new ArrayList<>();
        Prenda p3 = new Prenda("CC","CC01");
        Prenda p4 = new Prenda("CD","CC02");
        a2.add(p3);
        a2.add(p4);

        System.out.println("Sus prendas quedaron guardadas con la clave "+ gr.guardarPrendas(a2));
        System.out.println("Lista de productos "+ gr.devolverPrendas(2));

        gr.mostrarPrendas();
    }
}
