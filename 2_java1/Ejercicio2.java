package com.company;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        // Ejercicio 2 multiplos de m
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite n y m");
        int n= sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i<n;i++){
            System.out.println(i*m);
        }
    }
}
