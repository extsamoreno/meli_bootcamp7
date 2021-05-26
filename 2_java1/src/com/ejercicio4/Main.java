package com.ejercicio4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Ejercicio 2");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de numeros primos que quiere");
        int primeQuantityDesired = scanner.nextInt();
        int primeQuantityActual = 0;
        int number = 2;
        while (primeQuantityActual < primeQuantityDesired){
            if (isPrime(number)) {
                primeQuantityActual++;
                System.out.print(number + ",");
            }
            number++;
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


