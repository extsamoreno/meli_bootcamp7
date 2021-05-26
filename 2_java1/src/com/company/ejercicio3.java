package com.company;

import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese un número para saber si es primo:");
        int num = scan.nextInt();

        if(methods.isPrime(num))
            System.out.println("Es primo");
        else
            System.out.println("NO es primo");
    }
}
