package practicaTM.ejercicio1;

import practicaTM.Utils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GuardaRopa ropero = new GuardaRopa();
        Campera camp1 = new Campera("air", "nike");
        Campera camp2 = new Campera("boost", "adidas");

        Campera camp3 = new Campera("otro", "nike");
        Campera camp4 = new Campera("otro", "adidas");

        List<Prenda> lista1 = Utils.listof(new Prenda[]{camp1, camp2});

        List<Prenda> lista2 = Utils.listof(new Prenda[]{camp3, camp4});

        Integer posix = ropero.guardarPrendas(lista1);
        Integer posix1 = ropero.guardarPrendas(lista2);

        System.out.println("Todas las prendas");
        ropero.mostrarPrendas();

        System.out.println("Prendas ID: " + posix);
        List<Prenda> listaDev = ropero.devolverPrendas(posix);
        Utils.printArr(listaDev);

        System.out.println("Prendas ID: " + posix1);
        List<Prenda> listaDev1 = ropero.devolverPrendas(posix1);
        Utils.printArr(listaDev1);


    }
}
