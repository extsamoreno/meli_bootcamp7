package com.company;

import java.util.Scanner;

public class Ej4 {

    public void mostrarPrimos() {
        Ej3 ej3 = new Ej3();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un numero: ");
        int n = scanner.nextInt();

        int number = 2;

        while (n > 0) {
            if (ej3.esPrimo(number, number - 1)) {
                System.out.println(number);
                n--;
            }
            number++;
        }
    }
}
