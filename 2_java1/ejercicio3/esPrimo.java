package ejercicio3;

import java.util.Scanner;

public class esPrimo {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hola! Este programa le permitirá saber si un número entero es primo :)");

        System.out.println("Ingrese un número entero: ");
        int numero = scanner.nextInt();

        int cantMultiplos = 0;
        for(int i=1; i<=numero;i++){
            if(numero % i == 0){
                cantMultiplos++;
            }
        }

        if(cantMultiplos == 2){
            System.out.println("El número " + numero + " es primo");
        } else {
            System.out.println("El número " + numero + " no es primo");
        }

        scanner.close();
    }
}