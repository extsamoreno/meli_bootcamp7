package com.company;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LogMessage("Ingrese un número para testear que sea primo");

        int numberPrimo = scanner.nextInt();

        String message = IsPrimo(numberPrimo) ? "El número es primo" : "El número no es primo";

        LogMessage(message);
    }

    public static void LogMessage(String message) {
        System.out.println(message);
    }

    //Para probar que eun numero es primo, tenemos que ver si es divisible solo por el mismo y por 0
    public static boolean IsPrimo(int number) {

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
}
