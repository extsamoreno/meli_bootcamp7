package com.company;

import java.util.Scanner;

public class methods {

    public static boolean isPair(int n){
        if(n%2 == 0)
            return true;

        return false;
    }

    public static int getMultiplication(int num1, int num2){
        return num1 * num2;
    }

    public static boolean isPrime(int num){
        boolean prime = true;

        for(int i = 2; i < num; i++) {
            if (num % i == 0) {
                prime = false;
                break;
            }
        }

        return prime;
    }


}
