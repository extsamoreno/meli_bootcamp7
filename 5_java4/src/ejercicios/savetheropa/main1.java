package ejercicios.savetheropa;

import java.util.ArrayList;
import java.util.List;

public class main1 {

    public static void main(String[] args) {

        Pantalon pantalon1 = new Pantalon("nike", "f300");
        Campera campera1 = new Campera("Adidas", "90");

        Pantalon pantalon2= new Pantalon("Topper", "sportivo");
        Campera campera2 = new Campera("NewBalance", "Pro");



        List<Prenda> lista1 = new ArrayList<>();

        lista1.add(pantalon1);
        lista1.add(campera1);

        List<Prenda> lista2 = new ArrayList<>();

        lista2.add(pantalon2);
        lista2.add(campera2);


        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(lista1);
        guardaRopa.guardarPrendas(lista2);



        guardaRopa.mostrarPrendas();

        guardaRopa.devolverPrendas(1);




    }
}
