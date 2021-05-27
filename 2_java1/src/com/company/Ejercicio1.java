package com.company;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        int numero;
        int contador = 0;
        System.out.println("Ingrese la cantidad de numeros pares a mostrar: ");
	    Scanner entrada = new Scanner(System.in);
	    numero = entrada.nextInt();
        for (int i = 0; contador < numero; i++) {
            if (esPar(i)) {
                System.out.println(i);
                contador++;
            }
        }
        entrada.close();
    }

    public static boolean esPar (int numero) {
        return (numero % 2 == 0);
    }
}
