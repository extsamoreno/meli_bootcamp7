package com.company;

import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        int numero;
        int contador = 0;
        System.out.println("Ingrese la cantidad de numeros primos: ");
        Scanner entrada = new Scanner(System.in);
        numero = entrada.nextInt();
        for (int i = 0; contador < numero; i++) {
            if (esPrimo(i)){
                System.out.println(i);
                contador++;
            }
        }
        entrada.close();
    }

    public static boolean esPrimo (int numero) {
        int contador = 2;
        boolean primo = true;
        while (primo && (contador != numero)) {
            if (numero % contador == 0)
                primo = false;
            contador++;
        }
        return primo;
    }
}
