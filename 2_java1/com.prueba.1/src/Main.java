import ejercicios.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] params){
        imprimirMenu();
    }

    private static void ejecutarEjercicio(){
        Scanner scanner= new Scanner(System.in);
        int num = scanner.nextInt();

        switch (num){
            case 1:
                System.out.println("ingrese el valor de los N primeros numeros pares que desea ver:");
                int cantNumerosPares=scanner.nextInt();
                Ejercicio1.NumerosPares(cantNumerosPares);
                break;
            case 2:
                System.out.println("ingrese el valor del Multiplo:");
                int numMultiple = scanner.nextInt();
                System.out.println("ingrese el valor de la cantidad de multiplos que desea ver:");
                int numCant = scanner.nextInt();
                Ejercicio2.nPrimerosMultiplo(numMultiple,numCant);
                break;
            case 3:
                System.out.println("ingrese el numero que desea saber si es primo:");
                int numPrimo=scanner.nextInt();
                Ejercicio3.esPrimo(numPrimo);
                break;
            case 4:
                System.out.println("ingrese la cantidad de numeros primos que desea ver:");
                int cantPrimo=scanner.nextInt();
                Ejercicio4.nPrimerosPrimos(cantPrimo);
                break;
            case 5:
                System.out.println("ingrese el numero que desea ver:");
                int number=scanner.nextInt();
                System.out.println("ingrese la cantidad de veces que debe aparecer en el numero natural:");
                int cant=scanner.nextInt();
                System.out.println("ingrese la cantidad de numeros que quiere ver que cumplan la condicion anterior:");
                int veces= scanner.nextInt();
                Ejercicio5.construccionDeNumeros(number,cant,veces);
                break;
            default:
                scanner.close();
                imprimirMenu();

        }
    }


    private static void imprimirMenu(){
        System.out.println("Ingrese el numero del ejercicio que desea resolver:");
        System.out.println("1. N primeros numeros pares");
        System.out.println("2. N primeros multiplos de M");
        System.out.println("3. N es primo");
        System.out.println("4. N primeros numeros primos");
        System.out.println("5. N primeros numeros que contenga M veces el Numero d");
        ejecutarEjercicio();
    }

}
