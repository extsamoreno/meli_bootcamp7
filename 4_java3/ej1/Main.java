package ejercitacionMañana.ej1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("A1", 123);
        Persona p2 = new Persona("A2", 345);
        Persona p3 = new Persona("A3", 023);

        Persona[] personas = {p1, p2, p3};

        SortUtil.ordenar(personas);

        for (Persona p : personas) {
            System.out.println("nombre: " + p.getNombre());
        }

        Celular c1 = new Celular(12, "A1");
        Celular c2 = new Celular(33, "A2");
        Celular c3 = new Celular(04, "A3");

        Celular[] celulares = {c1,c2,c3};
        SortUtil.ordenar(celulares);

        for (Celular c : celulares) {
            System.out.println("titular: " + c.getTitular());
        }

    }
}
