package com.meli;

import java.util.Scanner;

import static com.meli.Titulo.titulo;

public class PuntoTres {
    public static void esNumeroPrimo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, ingrese un número: ");
        int numero = scanner.nextInt();
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
            System.out.println(numero + " es Primo!!");
        } else {
            System.out.println(numero + " no es Primo!!");
        }
    }

    public static void main(String[] args) {
        titulo("Punto 3");
        esNumeroPrimo();
    }
}
