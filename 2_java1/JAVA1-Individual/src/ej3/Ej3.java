package ej3;

import java.util.Scanner;

public class Ej3 {

    /*
    Desarrollar un programa para informar si un número n es primo o no,
    siendo n un valor que el usuario ingresará por consola.
    Recordá que un número es primo cuando sólo es divisible por sí mismo y por 1.
     */

    public static void main (String[] args) {

        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        if(isPrime(n) == true) {
            System.out.println(n + " es Primo");
        } else {
            System.out.println(n + " NO es Primo");
        }
        in.close();

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
