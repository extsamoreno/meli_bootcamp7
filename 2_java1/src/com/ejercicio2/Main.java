package com.ejercicio2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Ejercicio 2");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese cuantos multiplos quiere");
        int n = scanner.nextInt();

        System.out.println("Y de que numero?");
        int m = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println(i*m);
        }
    }
}
