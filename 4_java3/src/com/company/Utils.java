package com.company;

import java.util.Random;

public class Utils {
    public static void printArrayPersonas(Precedable<Persona> arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void printArrayCelulares(Precedable<Celular> arr[]) {
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

}
