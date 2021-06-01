package Ex1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa gr = new GuardaRopa(1);
        List<Prenda> listaPrendas = new ArrayList<>();
        Prenda p1 = new Prenda("Adidas" ,"l1");
        Prenda p2 = new Prenda("Nike" ,"l2");
        listaPrendas.add(p1);
        listaPrendas.add(p2);

        Integer i = gr.guardarPrendas(listaPrendas);
        System.out.println("Se guardaron bajo el id : " + i);
        gr.mostrarPrendas();



    }
}
