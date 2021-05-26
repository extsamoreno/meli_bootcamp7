package com.company;

import java.util.Scanner;

public class EjercicioUno {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de numeros pares que desea obtener: ");
        int numeroIngresado = scanner.nextInt();
        numerosPares(numeroIngresado);

    }

    public static void numerosPares(int numeroLimite) {
        int numerosParesTotales = 0;
        System.out.println("Los numeros pares son : ");
        for (int numero = 1; numerosParesTotales < numeroLimite; numero++) {
            if (numero % 2 == 0) {
                System.out.print(numero + " ");
                numerosParesTotales++;
            }
        }
    }
}
