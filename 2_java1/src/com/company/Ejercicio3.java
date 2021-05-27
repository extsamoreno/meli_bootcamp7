package com.company;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        int numero;
        int contador = 0;
        System.out.println("Ingrese el numero: ");
        Scanner entrada = new Scanner(System.in);
        numero = entrada.nextInt();
        if (esPrimo(numero)){
            System.out.println(numero + " es primo");
        }
        else {
            System.out.println(numero + " no es primo");
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
