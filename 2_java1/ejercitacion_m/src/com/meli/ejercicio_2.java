package com.meli;

import java.util.Scanner;

public class ejercicio_2 {
    public static boolean esMultiplo(int multiplo, int m) {
        return multiplo%m==0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el numero al que desea obtener los multiplos: ");
        int m = scanner.nextInt();

        System.out.println("Ingrese la cantidad de multiplos: ");
        int n = scanner.nextInt();

        int multiplos = 0, i = 0;

        while(i != n) {
            if( esMultiplo(multiplos, m) ) {
                System.out.println(multiplos);
                i++;
            }
            multiplos++;
        }

        scanner.close();
    }
}
