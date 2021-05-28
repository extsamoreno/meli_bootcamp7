package com.company;

import java.util.Scanner;

public class Ej2 {

    public void divisible(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un primer numero: ");
        int n = scanner.nextInt();

        System.out.println("Ingrese un segundo numero: ");
        int m = scanner.nextInt();

        int number = 1;
        while(n >=0){

            System.out.println(m*number);
            n--;
            number++;

        }
    }
}
