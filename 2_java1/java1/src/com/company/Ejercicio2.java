package com.company;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Maybe un trycatch ahí para saber que es numero coso
        LogMessage("Ingrese un número");

        int numberFromScanner = scanner.nextInt();

        LogMessage("Ingrese un número para ver los multiplos");

        int numberFromScannerToTest = scanner.nextInt();

        CheckMultipliers(numberFromScanner, numberFromScannerToTest);
    }

    public static void LogMessage(String message) {
        System.out.println(message);
    }

    public static boolean IsDivisible(int numberToTest, int numberMulti) {
        return ((numberToTest % numberMulti) == 0);
    }

    public static void CheckMultipliers(int number, int numberToTest) {
        for (int i = 0; i <= number; i++){
            if(IsDivisible(i, numberToTest)) {
                LogMessage("El número " + i + " es divisible por " + numberToTest);
            }
        }
    }
}
