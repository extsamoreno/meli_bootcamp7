package com.meli;

import java.util.Scanner;

public class PuntoCuatro {
    public static void titulo (String titulo){

        System.out.println("=" + "=".repeat(titulo.length()) + "=");
        System.out.println("#" + titulo + "#");
        System.out.println("=" + "=".repeat(titulo.length()) + "=");
    }

    public static boolean esNumeroPrimo(int numero) {

        boolean esPrimo = false;

        if (numero == 2) {
            esPrimo = true;
        } else {
            for (int i = 2; i < numero; i++) {
                if (numero%i == 0) {
                    esPrimo = false;
                    break;
                } else {
                    esPrimo = true;
                }
            }
        }

        if (esPrimo) {
            return true;
        } else {
            return false;
        }
    }

    public static void listaNumerosPrimos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, ingrese un número: ");
        int numero = scanner.nextInt();
        int contador = 0;
        System.out.println("Los " + numero + " primeros numeros primos son: ");
        for (int i = 0; i < numero; ) {
            if (esNumeroPrimo(contador)) {
                System.out.println(contador);
                contador++;
                i++;
            } else {
                contador++;
            }
        }
    }

    public static void main(String[] args) {
        titulo("Punto 4");
        listaNumerosPrimos();
    }
}
