package savetheropa;

import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<savetheropa.Prenda> listaPrendas = new ArrayList<>();

        System.out.println("Hola! Este programa le permitirá crear un guardarropas con 2 prendas y luego reclamarlas \n");

        System.out.println("Comencemos con la primera prenda");
        System.out.println("¿Qué tipo de prenda es? Ingrese el número correspondiente: 1 Remera 2 Buzo 3 Jean");
        int tipoPrenda1 = scanner.nextInt();
        System.out.println("Ingrese la marca de la prenda: ");
        String marcaPrenda1 = scanner.next();
        System.out.println("Ingrese el modelo de la prenda: ");
        String modeloPrenda1 = scanner.next();

        if(tipoPrenda1 == 1){
            savetheropa.Prenda remera = new savetheropa.Remera(marcaPrenda1, modeloPrenda1);
            listaPrendas.add(remera);
        } else if(tipoPrenda1 == 2) {
            savetheropa.Prenda buzo = new savetheropa.Buzo(marcaPrenda1, modeloPrenda1);
            listaPrendas.add(buzo);
        } else if(tipoPrenda1 == 3){
            savetheropa.Prenda jean = new savetheropa.Jean(marcaPrenda1, modeloPrenda1);
            listaPrendas.add(jean);
        }

        System.out.println("\nSigamos con la segunda prenda");
        System.out.println("¿Qué tipo de prenda es? Ingrese el número correspondiente: 1 Remera 2 Buzo 3 Jean");
        int tipoPrenda2 = scanner.nextInt();
        System.out.println("Ingrese la marca de la prenda: ");
        String marcaPrenda2 = scanner.next();
        System.out.println("Ingrese el modelo de la prenda: ");
        String modeloPrenda2 = scanner.next();

        if(tipoPrenda2 == 1){
            savetheropa.Prenda remera = new savetheropa.Remera(marcaPrenda2, modeloPrenda2);
            listaPrendas.add(remera);
        } else if(tipoPrenda2 == 2) {
            savetheropa.Prenda buzo = new savetheropa.Buzo(marcaPrenda2, modeloPrenda2);
            listaPrendas.add(buzo);
        } else if(tipoPrenda2 == 3){
            savetheropa.Prenda jean = new savetheropa.Jean(marcaPrenda2, modeloPrenda2);
            listaPrendas.add(jean);
        }

        savetheropa.GuardaRopa guardaRopa = new savetheropa.GuardaRopa();
        int idGuardaRopa = guardaRopa.guardarPrendas((listaPrendas));
        System.out.println("\nSe guardaron las prendas en el guardarropas con ID " + idGuardaRopa + "\n");

        System.out.println("Las prendas disponibles en el guardarropas son: ");
        guardaRopa.mostrarPrendas();

        System.out.println("\nIngrese el ID de su guardarropas: ");
        int idGuardaRopaIngresado = scanner.nextInt();

        System.out.println("\nLe devolvemos las prendas de su guardarropas: ");
        System.out.println(guardaRopa.devolverPrendas(idGuardaRopaIngresado));
        System.out.println("Ya no se encuentran prendas en el guardarropas");

        scanner.close();
    }
}