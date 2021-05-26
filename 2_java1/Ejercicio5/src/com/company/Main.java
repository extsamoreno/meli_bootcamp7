package com.company;
import java.util.Scanner;
public class Main {
    private static Scanner sc;
    public static void main(String[] args) {
        // write your code here


        int count = 2;
        sc = new Scanner(System.in);

        System.out.print(" Ingresar un numero : ");
        int num = sc.nextInt();

        for(int i = 10; i <= num; i++) {
            System.out.print(i + ", ");
        }
        System.out.println("");

    }
}
