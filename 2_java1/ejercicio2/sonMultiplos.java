package ejercicio2;

import java.util.Scanner;

public class sonMultiplos{
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hola! Este programa le permitirá saber la cantidad de multiplos de un número entero que usted desee :)");

        System.out.println("Ingrese el número entero del cual desea saber sus multiplos: ");
        int numero = scanner.nextInt();

        System.out.println("Ingrese la cantidad de múltiplos que desea saber: ");
        int cantMultiplos = scanner.nextInt();

        int count = 0;
        int multiplo = 1;
        while(count < cantMultiplos){
            if(multiplo % numero == 0){
                System.out.println("El número " + multiplo + " es múltiplo de " + numero);
                count++;
            }
            multiplo++;
        }

        scanner.close();
    }
}