package com.company;

import java.util.Scanner;

public class Ejercicio1 {
    // Ejercicio primeros n pares
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite n");
        int n= sc.nextInt();
        int i=0, count=0;
        while(count!=n){
            if(i%2==0){
                System.out.println(i);
                count++;
            }
           i++;
        }
    }
}
