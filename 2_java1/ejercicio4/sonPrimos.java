package ejercicio4;

import java.util.Scanner;

public class sonPrimos {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hola! Este programa le permitirá saber la cantidad de números primos que desee :)");

        System.out.println("Ingrese la cantidad de números primos que desea saber: ");
        int cantPrimos = scanner.nextInt();

        int count = 0;
        int numero = 1;
        while(count < cantPrimos){
            int cantMultiplos = 0;
            for(int i=1; i<=numero;i++){
                if(numero % i == 0){
                    cantMultiplos++;
                }
            }

            if(cantMultiplos == 2){
                System.out.println("El número " + numero + " es primo");
                count++;
            }

            numero++;
        }

        scanner.close();
    }
}