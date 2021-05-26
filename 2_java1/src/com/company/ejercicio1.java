package com.company;

import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de nros. pares que quiere ver:");
        int cant = scan.nextInt();

        for (int i = 1; i<=cant; i++){
            if(methods.isPair(i))
                System.out.println(i);
        }
    }

}
