package meli.ejerc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de ejercicio a ejecutar (1-5):");

        switch (scanner.nextInt()){
            case 1:
                Exercises.exerciseOne(scanner);
                break;
            case 2:
                Exercises.exerciseTwo(scanner);
                break;
            case 3:
                Exercises.exerciseThree(scanner);
                break;
            case 4:
                Exercises.exerciseFour(scanner);
                break;
            case 5:
                Exercises.exerciseFive(scanner);
                break;
            default:
                System.out.println("Whoops! Parece que no ingresaste un numero valido. (Intenta ingresando numeros del 1 al 5)");
                break;
            /*case 6:
                int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
                radixSort(arr);*/
        }
    }
}
