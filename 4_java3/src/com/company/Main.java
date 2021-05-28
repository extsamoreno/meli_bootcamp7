package com.company;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Precedable<Persona> arrayPersonas[] = new Precedable[10];

        for(int i = 0; i < 10; i++) {


            arrayPersonas[i] = new Persona("Genaro " + i, i + getRandomNumber());
        }

        System.out.println("Array sin ordenar");
        printArray(arrayPersonas);

        System.out.println("------");

        SortUtil.ordenar(arrayPersonas);

        System.out.println("Array ordenado");
        printArray(arrayPersonas);
    }

    public static void printArray(Precedable<Persona> arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int getRandomNumber() {
        Random rand = new Random(); //instance of random class
        int upperbound = 100;
        //generate random values from 0-24
        return rand.nextInt(upperbound);
    }
}
