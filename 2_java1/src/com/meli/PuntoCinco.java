package com.meli;

import java.util.Scanner;

public class PuntoCinco {
    public static void titulo (String titulo){
        System.out.println("=" + "=".repeat(titulo.length()) + "=");
        System.out.println("#" + titulo + "#");
        System.out.println("=" + "=".repeat(titulo.length()) + "=");
    }

    public static int vecesRepetido(String numeros, char numeroRepetido) {
        int numeroVeces = 0;
        char[] letras = numeros.toCharArray();
        //System.out.println("letras[0] = " + letras[0]);
        for ( char numero: letras) {
            if ( numero == numeroRepetido) {
                numeroRepetido++;
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

        for (int i = 0; i < cantidad; i++) {
            String numeroARevisar = Integer.toString(i);
            int veces = vecesRepetido(numeroARevisar, (char)numero);
            if( veces == cantidadVeces) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        titulo("Punto 5");
        primerosNumerosNaturales();
    }
}
