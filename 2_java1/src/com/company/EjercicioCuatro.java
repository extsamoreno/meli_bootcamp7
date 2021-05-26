package com.company;

import java.util.Scanner;

public class EjercicioCuatro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de numeros primos que desea obtener: ");
        int numeroIngresado = scanner.nextInt();

        obtenerPrimos(numeroIngresado);
    }

    private static void obtenerPrimos(int limite) {
        int primosTotales = 0;
        System.out.println("Los " + limite + " primeros primos son: ");
        for (int i = 1; primosTotales < limite; i++) {
            if (EjercicioTres.esPrimo(i)) {
                System.out.print(i + " ");
                primosTotales++;
            }

        }

    }
}
