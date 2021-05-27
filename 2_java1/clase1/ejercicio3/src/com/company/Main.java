//Desarrollar un programa para informar si un número n es primo o no, siendo n un valor que el usuario ingresará por consola.
//Recordá que un número es primo cuando sólo es divisible por sí mismo y por 1.

package com.company;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.print("índique un número para ver si es primo o no=");
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        System.out.println(nPrimo(n));
    }

    public static boolean nPrimo(int n) {
        if (n > 3) {
            for (int i = 2; i <= Math.round(Math.sqrt(n)); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;

    }
}


