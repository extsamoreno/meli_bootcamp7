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

        int [] array = searchFirstFiveNumbersWithSomeNumberIn(numberLimit, numberQuantityToSearch, numberToSearch);

        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    private static int[] searchFirstFiveNumbersWithSomeNumberIn(int numberLimit, int numberQuantityToSearch, int numberToSearch) {

        int finded = 1;
        int[] arrayNumbers = new int[numberLimit];
        int i = 0;
        while(finded <= numberLimit) {
            String actualNumberString = Integer.toString(i);
            char numberToSearchChar = Integer.toString(numberToSearch).charAt(0); //Sacamos el numbero como char
            int quantityCharacter = getCharacterQuantity(actualNumberString, numberToSearchChar);

            if (quantityCharacter == numberQuantityToSearch) {
                arrayNumbers[finded - 1] = i;
                finded++;
            }
            i++;
        }

        return arrayNumbers;
    }

    public static void logMessage(String message) {
        System.out.println(message);
    }

    //Creamos esta función para encontrar las veces que está un caracter en un string, pasamos el número a string para poder buscarlo
    public static int getCharacterQuantity(String stringToTest, char charToSearch) {
        int cant = 0;
        int stringLength = stringToTest.length();

        for (int i = 0; i < stringLength; i++) {
            char charActual = stringToTest.charAt(i);
            if (charActual == charToSearch) {
                cant++;
            }
        }

        return cant;
    }
}
