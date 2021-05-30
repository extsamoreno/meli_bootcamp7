package com.company;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //testFactory();
       // testPersonas();
       // testCelular();
        testHundredThousandArraySort();
    }

    public static void testPersonas() {
        Precedable<Persona> arrayPersonas[] = new Precedable[10];

        for (int i = 0; i < 10; i++) {
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

        for (int i = 0; i < 10; i++) {
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

    public static void testFactory() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        testMultipleSorterInt();
        testMultipleSorterString();
    }

    public static void testMultipleSorterInt() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Object instance = MiFactory.getInstance("");
        Sorter<Integer> sorterInt = (Sorter<Integer>) instance;

        Integer[] randomArray = Utils.getRandomArrayInteger(10);

        Utils.printArrayInt(randomArray);

        System.out.println("--------");
        sorterInt.sort(randomArray, (a,b) -> a.compareTo(b));

        Utils.printArrayInt(randomArray);
    }

    public static void testMultipleSorterString() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Object instance = MiFactory.getInstance("");
        Sorter<String> sorterInt = (Sorter<String>) instance;

        String[] randomArray = Utils.getArrayString();

        Utils.printArrayObject(randomArray);

        System.out.println("--------");
        sorterInt.sort(randomArray, (a,b) -> a.compareTo(b));

        Utils.printArrayObject(randomArray);
    }

    public static void testHundredThousandArraySort() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Integer[] array = Utils.getHundredThousandArraySorted();

        Time time = new Time();
        time.start();

        Object instance = MiFactory.getInstance("");
        Sorter<Integer> sorterInt = (Sorter<Integer>) instance;

        sorterInt.sort(array, (a,b) -> a.compareTo(b));

        time.stop();

        System.out.println(time);

    }
}
