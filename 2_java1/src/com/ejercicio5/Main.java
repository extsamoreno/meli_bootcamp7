package com.ejercicio5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Ejercicio 2");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de numeros que quiere");
        int numberQuantityDesired = scanner.nextInt();
        System.out.println("Ingrese el digito que quiere incluir");
        int includeNumber = scanner.nextInt();
        System.out.println("Y cuantos de ellos quiere");
        int includeNumberQuantity = scanner.nextInt();

        for (int i = 0; i <numberQuantityDesired ; i++) {

        }

    }

    public static boolean isPrime(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
}


