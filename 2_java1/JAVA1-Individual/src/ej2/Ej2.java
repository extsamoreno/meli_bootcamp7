package ej2;

import java.util.Scanner;

public class Ej2 {

    /*
    Desarrollar un programa para mostrar los primeros n múltiplos de m,
    siendo n y m valores que el usuario ingresará por consola.
    Recordá que un número a es múltiplo de b si a es divisible por b.
     */

    public static void main (String[] args) {

        int n, m;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        firstNMultiplesOfM(n, m);
        in.close();

    }

    public static void firstNMultiplesOfM(int n, int m) {

        int number = m;
        System.out.println("0");
        for (int i = 2; i <= n; i++) {
            System.out.println(number);
            number += m;
        }

    }

}
