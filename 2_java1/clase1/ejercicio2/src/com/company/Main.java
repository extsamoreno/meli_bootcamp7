//Desarrollar un programa para mostrar los primeros n múltiplos de m, siendo n y m valores que el usuario ingresará por consola.
//Recordá que un número a es múltiplo de b si a es divisible por b. 

package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("índique N: ");
        int totalPrint = scan.nextInt();

        System.out.println("índique M: ");
        int subject = scan.nextInt();

        int a = 0;
        for(int i = 0; a < totalPrint; i++) {
            System.out.println(i*subject);
            a++;
        }
    }
}


