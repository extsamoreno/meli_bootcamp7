package meli.ejerc;

import javax.swing.plaf.synth.Region;
import java.util.Scanner;

public class Exercises {

    private static boolean checkNumber(int num, String numToFind, int numQty){
        String numInStr;
        numInStr = String.valueOf(num);
        int count = 0;
        for (int i=0; i < numInStr.length(); i++){
            if(String.valueOf(numInStr.charAt(i)).equals(numToFind)){
                count++;
            };
        }

        if(count == numQty){
            return true;
        }
        return false;
    }

    private static boolean isPrime(int num){
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void getPrimeNumbers(int qty){
        int lastPrime = 2;
        int found = 0;
        int aux = 1;

        while(found < qty){
            aux++;
            if(isPrime(aux)) {
                found++;
                System.out.println(aux);
            }
        }
    }

    public static void exerciseOne(Scanner scann){
        System.out.println("Hola! Por favor ingrese la cantidad de numeros pares que desea ver en pantalla:");
        int count = 1;
        int maxAmount = scann.nextInt();
        int evenNmbrsFound = 0;
        boolean keepLooking = true;

        while(keepLooking) {
            if (evenNmbrsFound >= maxAmount) {
                keepLooking = false;
            }
            if (count % 2 == 0) {
                System.out.println(count);
                evenNmbrsFound++;
            }
            count++;
        }
    }

    public static void exerciseTwo(Scanner scann){
        System.out.println("Numero a analizar:");
        int mainNumber = scann.nextInt();

        System.out.println("Cantidad de multiplos a mostrar:");
        int multiplesQty = scann.nextInt();

        for(int i=1;i<=multiplesQty;i++){
            System.out.println(mainNumber * i);
        }
    }

    public static void exerciseThree(Scanner scann){
        System.out.println("Ingrese numero a analizar:");
        int numberToAnalyze = scann.nextInt();

        if(isPrime(numberToAnalyze)){
            System.out.println("El numero ES PRIMO!");
        }
        else{
            System.out.println("El numero NO ES PRIMO!");
        }
    }

    public static void exerciseFour(Scanner scann){
        System.out.println("Ingrese cantidad de numeros primos a mostrar:");
        int primesQty = scann.nextInt();

        getPrimeNumbers(primesQty);
    }

    public static void exerciseFive(Scanner scann){
        System.out.println("Ingrese cantidad de numeros totales a mostrar:");
        int maxQty = scann.nextInt();
        System.out.println("¿Que numero se debe buscar?");
        String mainNumber = scann.next();
        System.out.println("¿Cuantas veces se debe repetir dicho numero?");
        int numberRecurrence = scann.nextInt();

        int found = 0;
        int aux = 0;
        while(found < maxQty){
            aux++;
            if(checkNumber(aux,mainNumber,numberRecurrence)){
                System.out.println(aux);
                found++;
            }
        }
    }
}
