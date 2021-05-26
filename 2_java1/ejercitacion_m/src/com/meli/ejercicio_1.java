package com.meli;

import java.util.Scanner;

public class ejercicio_1 {

    public static boolean esPar(int n) {
        return n%2==0;
    }

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de numeros pares que desea: ");
	    int n = scanner.nextInt();
	    int pares = 0, i = 0;

	    while(i != n) {
	        if( esPar(pares) ) {
                System.out.println(pares);
                i++;
            }
	        pares++;
        }

	    scanner.close();
    }
}
