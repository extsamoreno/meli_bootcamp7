package com.company;

import java.util.Scanner;

public class Ej3 {

    public void ej3(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un numero: ");
        int n = scanner.nextInt();

        int number = n-1;

        if(esPrimo(n,number)){
            System.out.println("Es un numero primo");
        }else {
            System.out.println("No es un numero primo");
        }
    }

    public boolean esPrimo( int n, int number){

        while(number >1) {
            if (n % number == 0) {
                return false;
            } else {
                number--;
            }
        }
        return true;
    }
}
