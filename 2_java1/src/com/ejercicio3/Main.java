package com.ejercicio3;
import java.lang.Math;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Ejercicio 2");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un numero para saber si es primo");
        int number = scanner.nextInt();

        if (isPrime(number)) {
            System.out.println("El numero es primo");
        } else {
            System.out.println("El numero no es primo");
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


