package com.bootcamp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option = -1;

        int n, m, d;

        while (option != 6) {

            System.out.println("\nQue desea hacer? Ingrese un número para escoger una opción\n" +
                    "1. Obtener los primeros n números pares\n" +
                    "2. Obtener los primeros n múltiplos de m\n" +
                    "3. Saber si un número n es primo o no\n" +
                    "4. Obtener los primeros n números primos\n" +
                    "5. Obtener los primeros n números naturales que tienen al menos m dígitos d.\n" +
                    "6. Salir");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\nObtener los primeros n números pares:\n" +
                            "Ingrese un número n:");
                    Numbers.nPairNumbers(scanner.nextInt());
                    break;

                case 2:
                    System.out.println("\nObtener los primeros n múltiplos de m\n" +
                            "Ingrese un número n:");
                    n = scanner.nextInt();
                    System.out.println("Ingrese m:");
                    m = scanner.nextInt();

                    System.out.println();
                    Numbers.nMultiplesOfM(n, m);
                    break;

                case 3:
                    System.out.println("\nSaber si un número n es primo o no\n" +
                            "Ingrese un número n:");

                    boolean result = Numbers.isPrimeNumber(scanner.nextInt());

                    if (result) {
                        System.out.println("Es primo");
                    } else {
                        System.out.println("No es primo");
                    }

                    break;

                case 4:
                    System.out.println("\nObtener los primeros n números primos\n" +
                            "Ingrese un número n:");

                    n = scanner.nextInt();
                    System.out.println("\nLos primeros " + n + " números primos son:");
                    Numbers.nPrimeNumbers(n);
                    break;

                case 5:
                    System.out.println("\n" +
                            "Obtener los primeros n números naturales que tienen al menos m dígitos d.\n" +
                            "Ingrese n:");
                    n = scanner.nextInt();
                    System.out.println("Ingrese m:");
                    m = scanner.nextInt();
                    System.out.println("Ingrese d:");
                    d = scanner.nextInt();

                    Numbers.nNumbersWithMDigitsD(n, m, d);
                    break;

                case 6:
                    System.out.println("Adios!");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }

        }

    }
}
