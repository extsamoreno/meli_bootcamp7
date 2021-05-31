package bootcamp;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Prenda> ropa1, ropa2, devolucion;
        Prenda p1, p2, p3;
        p1 = new Prenda("Guci", "Campera");
        p2 = new Prenda("Guci", "Buzo");
        p3 = new Prenda("Guci", "Abrigo");

        ropa1 = new ArrayList<Prenda>();
        ropa2 = new ArrayList<Prenda>();

        ropa1.add(p1);
        ropa1.add(p2);
        ropa2.add(p3);


        GuardaRopa gr = new GuardaRopa();

        int ticket1 = gr.guardarPrendas(ropa1);
        int ticket2 = gr.guardarPrendas(ropa2);

        System.out.println("ticket1 = " + ticket1);

        gr.mostrarPrendas();

        devolucion = (ArrayList<Prenda>) gr.devolverPrendas(1);

        System.out.println("devolucion = " + devolucion);

        gr.mostrarPrendas();
    }
}
