package ej4;

import java.util.Scanner;

public class Ej4 {

    /*
    Desarrollar un programa para mostrar por consola los primeros n números primos,
     siendo n un valor que el usuario ingresará por consola.
     */

    public static void main (String[] args) {

        int n;
        int prime = 0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        for(int i = 0; i < n ; i++) {
            prime = nextPrime(prime);
            System.out.println(prime);
        }

        in.close();

    }

    public static int nextPrime(int n) {

        int number = n + 1;

        while(!isPrime(number)) {
            number++;
        }

        return number;

    }

    public static boolean isPrime(int n) {

        if(n <= 1) {
            return false;
        } else {
            for(int i = 2; i <= n/2; i++) {
                if((n % i) == 0) {
                    return false;
                }
            }
        }

        return true;

    }

}
