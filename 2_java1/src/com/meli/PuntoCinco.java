package com.meli;

import java.util.Scanner;

public class PuntoCinco {
    public static void titulo (String titulo){
        System.out.println("=" + "=".repeat(titulo.length()) + "=");
        System.out.println("#" + titulo + "#");
        System.out.println("=" + "=".repeat(titulo.length()) + "=");
    }

    public static void primerosNumerosNaturales() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, ingrese la cantidad de numeros que desea visualizar: ");
        int cantidad = scanner.nextInt();

        System.out.print("Por favor, ingrese la cantidad de veces que desea que se repita el numero: ");
        int cantidadVeces = scanner.nextInt();

        System.out.print("Por favor, ingresa el número que desea que se repita: ");
        int numero = scanner.nextInt();

        String palabra = "303";

        if(palabra.contains("3")){
            System.out.println("HOla Mundo");
        }
    }

    public static void main(String[] args) {
        titulo("Punto 5");
        primerosNumerosNaturales();
    }
}
