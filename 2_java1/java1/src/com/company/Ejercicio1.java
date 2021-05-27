package com.company;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Maybe un trycatch ahí para saber que es numero coso
        LogMessage("Ingrese un número");

        int numberFromScanner = scanner.nextInt();

        CheckPairsFromNumber(numberFromScanner);

    }

    public static void LogMessage(String message) {
        System.out.println(message);
    }

    public static boolean IsPair(int number) {
        return ((number % 2) == 0);
    }

    public static void CheckPairsFromNumber(int number) {
        for (int i = 0; i <= number; i++) {
            if (IsPair(i)) {
                LogMessage("El número " + i + " es par");
            }
        }
    }
}
