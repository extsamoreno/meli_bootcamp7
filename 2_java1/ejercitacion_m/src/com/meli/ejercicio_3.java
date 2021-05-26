package com.meli;

import java.util.Scanner;

public class ejercicio_3 {

    public static boolean esPrimo(int n) {
        int divisores = 0, i = 1;

        while(i <= n) {
            if(n%i == 0) {
                divisores++;
            }
            i++;
        }

        return divisores == 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el numero que desea conocer si es primo: ");
        int n = scanner.nextInt();

        if( esPrimo(n) ) {
            System.out.println("El numero ingresado es primo");
        } else {
            System.out.println("El numero ingresado no es primo");
        }

        scanner.close();
    }
}
