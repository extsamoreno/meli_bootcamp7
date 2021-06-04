package GuardaRopaExercise;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa g = new GuardaRopa();

        Prenda p1 = new Prenda("Adidas", "Campera");
        Prenda p2 = new Prenda("Custom", "Paraguas");

        Integer usedKey = g.guardarPrendas(List.of(p1, p2));

        g.mostrarPrendas();


        Prenda p3 = new Prenda("GG", "Cartera");
        Prenda p4 = new Prenda("Custom", "Gorra");

        Integer usedKey2 = g.guardarPrendas(List.of(p3, p4));

        g.mostrarPrendas();

        g.devolverPrendas(3);
        g.devolverPrendas(usedKey);
        g.mostrarPrendas();
        g.devolverPrendas(usedKey2);
    }
}
