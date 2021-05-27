package com.company;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        logMessage("Ingrese un número para encontrar todos los primos en ese intervalo");

        int numberLimit = scanner.nextInt(); //Obtenemos el numero primo hasta donde quiere testear

        checkIsPrimo(numberLimit);
    }

    public static void logMessage(String message) {
        System.out.println(message);
    }

    //Para probar que eun numero es primo, tenemos que ver si es divisible solo por el mismo y por 0
    public static boolean isPrimo(int number) {

        if(number < 1) { //Tiene que ser mayor a 1 para poder ver que sea primo, por ende retornamos falso
            return false;
        }

        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                return false; //si alguno dio 0, no es primo
            }
        }

        //Si no encontramos ninguno, significa que es primo, por 1 y por el mismo ya sabemos que es
        return true;
    }

    public static void checkIsPrimo(int number) {
        for(int i = 0; i <= number; i++) {
            if(isPrimo(i)) {
                logMessage("El número " + i + " es primo");
            }
        }
    }
}
