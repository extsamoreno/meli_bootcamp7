package com.company;

import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese un número para ver sus múltiplos:");
        int num = scan.nextInt();
        System.out.println("Ingrese la cant. de múltiplos que quiere ver:");
        int cant = scan.nextInt();

        System.out.println("Los primeros "+ cant +" múltiplos de "+num+" son:");
        for (int i = 1; i<=cant; i++){
            System.out.println(methods.getMultiplication(num, i));
        }
    }
}
