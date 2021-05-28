package com.company;

public class Main {

    public static void main(String[] args) {
       testPersonas();
       testCelular();
    }

    public static void testPersonas() {
        Precedable<Persona> arrayPersonas[] = new Precedable[10];

        for(int i = 0; i < 10; i++) {
            //Llenamos el array
            arrayPersonas[i] = new Persona("Genaro " + i, i + Utils.getRandomNumber());
        }

        System.out.println("Array sin ordenar");
        Utils.printArrayPersonas(arrayPersonas);

        System.out.println("------");

        SortUtil.ordenar(arrayPersonas);

        System.out.println("Array ordenado");
        Utils.printArrayPersonas(arrayPersonas);
    }

    public static void testCelular() {
        Precedable<Celular> arrayCelular[] = new Precedable[10];

        for(int i = 0; i < 10; i++) {
            //Llenamos el array
            arrayCelular[i] = new Celular(i + Utils.getRandomNumber(), "Genaro " + i);
        }

        System.out.println("Array sin ordenar");
        Utils.printArrayCelulares(arrayCelular);

        System.out.println("------");

        SortUtil.ordenar(arrayCelular);

        System.out.println("Array ordenado");
        Utils.printArrayCelulares(arrayCelular);
    }
}
