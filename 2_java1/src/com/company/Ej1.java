package com.company;

import java.util.Scanner;

public class Ej1 {

    public void pares() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un numero: ");
        int input = scanner.nextInt();

        int n = 0;
        while (input > 0) {
            System.out.println(n);
            n += 2;
            input--;
        }
    }

}
