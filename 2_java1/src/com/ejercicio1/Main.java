package com.ejercicio1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Ejercicio 1");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de numeros pares que quiere");
        String input = scanner.next();
        int numberQuantity = Integer.parseInt(input);

        for (int i = 0; i < numberQuantity; i++) {
            System.out.println(i*2);
        }
    }
}
