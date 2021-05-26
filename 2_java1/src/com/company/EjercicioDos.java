package com.company;

import java.util.Scanner;

public class EjercicioDos {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print( "Ingrese el numero del que desea conocer los multiplos : ");
        int numeroEvaluar = scanner.nextInt();
        System.out.print( "Ingrese el numero demultiplos que desea ver : ");
        int numeroMultiplos = scanner.nextInt();
        obtenerMultiplos(numeroEvaluar, numeroMultiplos);

    }

    public static void obtenerMultiplos(int numeroEvaluar, int numeroMultiplos) {
        int multiplosObtenidosTotales = 0;
        for (int i = 1; multiplosObtenidosTotales < numeroMultiplos; i++) {
            if (numeroEvaluar % i == 0) {
                multiplosObtenidosTotales++;
                System.out.print(i + "");
            }
        }
    }

}
