package com.company;

import java.util.Random;

public class Utils {
    public static void printArrayPersonas(Precedable<Persona> arr[]) {
        printArrayObject(arr);
    }

    public static void printArrayCelulares(Precedable<Celular> arr[]) {
        printArrayObject(arr);
    }

    public static void printArrayInt(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void printArrayObject(Object arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //Generamos un random number para ponerle al dni
    public static int getRandomNumber() {
        Random rand = new Random();
        int upperbound = 100;
        return rand.nextInt(upperbound);
    }

    public static Integer[] getRandomArrayInteger(int cant) {
        Integer[] arrayRet = new Integer[cant];

        for (int i = 0; i < cant; i++) {
            arrayRet[i] = getRandomNumber();
        }

        return arrayRet;
    }

    public static String[] getArrayString() {
        return new String[]{"X", "H", "A", "B", "D", "C"};
    }

    public static Integer[] getHundredThousandArraySorted() {
        Integer [] hundredThousandArray = new Integer[100000];

        for(int i = 0; i < 100000; i++) {
            hundredThousandArray[i] = i + 1;
        }

        return hundredThousandArray;
    }
}
