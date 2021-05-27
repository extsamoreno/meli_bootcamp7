package com.company;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        //contar desde char at?
        //dea?
        Scanner scanner = new Scanner(System.in);

        logMessage("Ingrese número limite para buscar");

        int numberLimit = scanner.nextInt();

        logMessage("Ingrese cantidad de numeros a buscar");

        int numberQuantityToSearch = scanner.nextInt();

        logMessage("Ingrese el número a buscar");

        int numberToSearch = scanner.nextInt();

    }

    public static void logMessage(String message) {
        System.out.println(message);
    }

    //Creamos esta función para encontrar las veces que está un caracter en un string, pasamos el número a string para poder buscarlo
    public static int getCharacterQuantity(String stringToTest, char charToSearch) {
        return 0;
    }
}
