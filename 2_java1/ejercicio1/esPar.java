package ejercicio1;

import java.util.Scanner;

public class esPar {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hola! Este programa le permitirá saber si un entero es par o no :)");

        System.out.println("Ingrese un número entero: ");
        int numero = scanner.nextInt();

        if(numero%2 == 0){
            System.out.println("El número " + numero + " es par");
        } else {
            System.out.println("El número " + numero + " no es par");
        }

        scanner.close();
    }
}