package com.company;

import java.util.Scanner;

public class EjercicioCinco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de numeros que desea obtener: ");
        int numeroLimite = scanner.nextInt();
        System.out.print("Ingrese el digito que desea ver: ");
        String digitoComparar = scanner.next();
        System.out.print("Ingrese el numero de digitos minimos que debe tener: ");
        int cantidadDigitos = scanner.nextInt();
        int cantidadNumerosObtenidos = 0;
        System.out.println("Los numeros encontrados son : ");
        for (int i = 0; cantidadNumerosObtenidos < numeroLimite; i++) {
            String numeroTexto = String.valueOf(i);
            String[] cadenaDigitos = numeroTexto.split("");
            int digitosMatch = 0;
            for (String cadenaDigito : cadenaDigitos) {
                if (cadenaDigito.compareTo(digitoComparar) == 0) {
                    digitosMatch++;
                }
            }
            if (digitosMatch == cantidadDigitos){
                cantidadNumerosObtenidos++;
                System.out.print(i + " ");
            }
        }
    }
}
