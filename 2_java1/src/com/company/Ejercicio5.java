package com.company;

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        int numero;
        int cantidad;
        char digito;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de numeros a mostrar: ");
        numero = scanner.nextInt();
        System.out.println("Ingrese la cantidad de digitos: ");
        cantidad = scanner.nextInt();
        System.out.println("Ingrese el digito: ");
        digito = scanner.next().charAt(0);

        int contador = 0;
        for (int i = 0; contador < numero; i++){
            if (numTimesAppears(String.valueOf(i), digito) == cantidad) {
                System.out.println(i);
                contador++;
            }
        }
    }

    public static int numTimesAppears(String str, char ch) {
        int count = 0;
        int i = 0;
        do {
            if (str.charAt(i) == ch) {
                count++;
            }
            i++;
        } while (str.length() > i);
        return count;
    }
}
