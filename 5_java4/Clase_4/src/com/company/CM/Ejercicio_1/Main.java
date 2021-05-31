package com.company.CM.Ejercicio_1;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Prenda> listaPrendas = new ArrayList<>();

        System.out.println("Hola! Este programa le permitirá crear un guardarropas con 2 prendas y luego reclamarlas \n");

        System.out.println("Comencemos con la primera prenda\n");
        System.out.println("¿Qué tipo de prenda es? Ingrese el número correspondiente: 1 Remera 2 Buzo 3 Jean");
        int tipoPrenda1 = scanner.nextInt();
        System.out.println("Ingrese la marca de la prenda: ");
        String marcaPrenda1 = scanner.next();
        System.out.println("Ingrese el modelo de la prenda: ");
        String modeloPrenda1 = scanner.next();

        if(tipoPrenda1 == 1){
            Prenda remera = new Remera(marcaPrenda1, modeloPrenda1);
            listaPrendas.add(remera);
        } else if(tipoPrenda1 == 2) {
            Prenda buzo = new Buzo(marcaPrenda1, modeloPrenda1);
            listaPrendas.add(buzo);
        } else if(tipoPrenda1 == 3){
            Prenda jean = new Jean(marcaPrenda1, modeloPrenda1);
            listaPrendas.add(jean);
        }

        System.out.println("Sigamos con la segunda prenda\n");
        System.out.println("¿Qué tipo de prenda es? Ingrese el número correspondiente: 1 Remera 2 Buzo 3 Jean");
        int tipoPrenda2 = scanner.nextInt();
        System.out.println("Ingrese la marca de la prenda: ");
        String marcaPrenda2 = scanner.next();
        System.out.println("Ingrese el modelo de la prenda: ");
        String modeloPrenda2 = scanner.next();

        if(tipoPrenda2 == 1){
            Prenda remera = new Remera(marcaPrenda2, modeloPrenda2);
            listaPrendas.add(remera);
        } else if(tipoPrenda2 == 2) {
            Prenda buzo = new Buzo(marcaPrenda2, modeloPrenda2);
            listaPrendas.add(buzo);
        } else if(tipoPrenda2 == 3){
            Prenda jean = new Jean(marcaPrenda2, modeloPrenda2);
            listaPrendas.add(jean);
        }

        GuardaRopa guardaRopa = new GuardaRopa();
        int idGuardaRopa = guardaRopa.guardarPrendas((listaPrendas));
        System.out.println("Se guardaron las prendas en el guardarropas con ID " + idGuardaRopa + "\n");

        System.out.println("Las prendas disponibles en el guardarropas son: ");
        guardaRopa.mostrarPrendas();

        System.out.println("Ingrese el ID de su guardarropas: ");
        int idGuardaRopaIngresado = scanner.nextInt();

        System.out.println(guardaRopa.devolverPrendas(idGuardaRopaIngresado));

        scanner.close();
    }


}