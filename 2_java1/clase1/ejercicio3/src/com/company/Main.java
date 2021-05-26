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


