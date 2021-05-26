package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduzca un número: ");
        int num = entrada.nextInt();

        if (num % 2 == 0) {
            System.out.println("El número ingresado es PAR");
        } else {
            System.out.println("El número ingresado NO es PAR");
        }
    }
}


