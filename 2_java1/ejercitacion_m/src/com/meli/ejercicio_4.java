package com.meli;

import java.util.Scanner;

public class ejercicio_4 {
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

        System.out.println("Ingrese la cantidad de numeros primos que desea: ");
        int n = scanner.nextInt();
        int primos = 0, i = 0;

        while(i != n) {
            if( esPrimo(primos) ) {
                System.out.println(primos);
                i++;
            }
            primos++;

        }

        scanner.close();
    }
}
