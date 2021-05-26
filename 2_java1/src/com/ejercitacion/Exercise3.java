package com.ejercitacion;

import java.util.Scanner;

public class Exercise3 {

    public static boolean isPrime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Check if a number is prime");
        int n = scanner.nextInt();
        for (int i = 2; i < n; i++) {
           if (n % i == 0) {
               return false;
           }
        }
        return true;
    }
}
