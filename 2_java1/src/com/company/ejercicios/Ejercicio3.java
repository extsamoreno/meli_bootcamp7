package com.company.ejercicios;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean esPrimo = true;

        for(var i = 2; i < n; i++){
            if(n % i == 0){
                esPrimo = false;
            }
        }

        if(!esPrimo){
            System.out.println("No es primo");
        } else {
            System.out.println("Es primo");
        }
    }
}
