package Practice.SaveTheRopa;

import Practice.Utils;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        GuardaRopa ropero= new GuardaRopa();
        Campera camp1= new Campera("air","nike");
        Campera camp2= new Campera("boost","adidas");

        Campera camp3= new Campera("otro","nike");
        Campera camp4= new Campera("otro","adidas");

        ArrayList<Prenda> lista1= new ArrayList<>();
        lista1.add(camp1);
        lista1.add(camp2);

        ArrayList<Prenda> lista2= new ArrayList<>();
        lista2.add(camp3);
        lista2.add(camp4);

        Integer posix= ropero.guardarPrenda(lista1);
        Integer posix1= ropero.guardarPrenda(lista2);


        ropero.mostrarPrendas();

        ArrayList<Prenda> listaDev=ropero.devolverPrendas(posix);

        System.out.println("prendas del lugar " + posix + ": ");
        Utils.printArrayList(listaDev);
    }
}