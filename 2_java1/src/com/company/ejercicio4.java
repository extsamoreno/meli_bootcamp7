package com.company;

import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de nros. a analizar:");
        int n = scan.nextInt();

        for (int i = 2; i <= n ; i++) {
            if(methods.isPrime(i))
                System.out.println(i);
        }
    }
}
