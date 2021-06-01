package Ejercicio1;

import Ejercicio1.GuardaRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Marca1","Modelo1");
        Prenda prenda2 = new Prenda("Marca2","Modelo2");


        ArrayList<Prenda> array = new ArrayList<>();
        array.add(prenda1);
        array.add(prenda2);

        GuardaRopa guardaRopa = new GuardaRopa();
        int codigo = guardaRopa.guardarPrendas(array);

        List<Prenda> listaPrendas =  guardaRopa.devolverPrendas(codigo);
        for (int i=0; i<listaPrendas.size();i++) {
            System.out.println(listaPrendas.get(i).getMarca()+" "+listaPrendas.get(i).getModelo());
        }




    }
}
