package com.company;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        int numero;
        int multiplicador;
        int contador = 0;

        System.out.println("Ingrese el numero: ");
	    Scanner num = new Scanner(System.in);
	    numero = num.nextInt();

        System.out.println("Ingrese la cantidad de multiplos: ");
        Scanner mult = new Scanner(System.in);
        multiplicador = mult.nextInt();

        for (int i = 0; contador < multiplicador; i++) {
            if (esMultiplo(numero, i)) {
                System.out.println(i);
                contador++;
            }
        }
        num.close();
        mult.close();
    }

    public static boolean esMultiplo (int numero, int multiplicador) {
        return (multiplicador % numero == 0);
    }
}
