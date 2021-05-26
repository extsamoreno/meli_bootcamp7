package com.company;

import java.util.Scanner;

public class EjercicioTres {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print( "Ingrese el numero a verificar si es primo : ");
        int numeroEvaluar = scanner.nextInt();


        if (esPrimo(numeroEvaluar)) {
            System.out.println("El numero " + numeroEvaluar + " es primo");
        }else {
            System.out.println("El numero " + numeroEvaluar + " no es primo");
        }
    }

    public static boolean esPrimo(int numeroEvaluar){
        int numeroDivisores = 0;
        for (int i = 1; i <= numeroEvaluar; i++) {
            if (numeroEvaluar % i == 0) {
                numeroDivisores++;
            }
        }
        return numeroDivisores == 2;

    }
}
