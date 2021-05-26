package com.meli;

import java.util.Scanner;

public class ejercicio_5 {
    public static void repeticiones(int n, int m, int d) {
        int i = 0, numeros = 0;

        while(i != n) {
            int repeticiones = 0;
            String num = String.valueOf(numeros);

            for(int j = 0; j < num.length(); j++) {
                if(Integer.parseInt(String.valueOf(num.charAt(j))) == d) {
                    repeticiones++;
                }
            }
            if(repeticiones == m) {
                System.out.println(numeros);
                i++;
            }
            numeros++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de numeros que desea: ");
        int n = scanner.nextInt();

        System.out.println("Ingrese la cantidad de digitos: ");
        int m = scanner.nextInt();

        System.out.println("Ingrese el digito a controlar: ");
        int d = scanner.nextInt();

        repeticiones(n,m,d);

        scanner.close();
    }
}
