package com.meli;

import java.util.Scanner;

public class PuntoCinco {

    public static void titulo (String titulo){
        System.out.println("=" + "=".repeat(titulo.length()) + "=");
        System.out.println("#" + titulo + "#");
        System.out.println("=" + "=".repeat(titulo.length()) + "=");
    }

    public static int vecesRepetido(String numeros, int numeroRepetido) {
        int numeroVeces = 0;
        for (int i = 0; i < numeros.length(); i++) {
            char numero = numeros.charAt(i);
            if( Character.getNumericValue(numero) == numeroRepetido) {
                numeroVeces++;
            }
        }

        return numeroVeces;
    }

    public static void primerosNumerosNaturales() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, ingrese la cantidad de numeros que desea visualizar: ");
        int cantidad = scanner.nextInt();

        System.out.print("Por favor, ingrese la cantidad de veces que desea que se repita el numero: ");
        int cantidadVeces = scanner.nextInt();

        System.out.print("Por favor, ingresa el número que desea que se repita: ");
        int numero = scanner.nextInt();

        int contador = 0;

        System.out.println("Los primeros " + cantidad + "números donde se repite " + numero + " " +
                cantidadVeces + " veces son:");
        for (int i = 0; i <= cantidad; ) {
            if(vecesRepetido(String.valueOf(contador), numero) == cantidadVeces) {
                System.out.println(contador);
                contador ++;
                i++;
            } else {
                contador ++;
            }
        }
    }

    public static void main(String[] args) {
        titulo("Punto 5");
        primerosNumerosNaturales();

    }
}
