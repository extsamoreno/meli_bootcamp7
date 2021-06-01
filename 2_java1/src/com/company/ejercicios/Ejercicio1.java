package com.company.ejercicios;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(var i = 0; i <= n; i++){
            if(i%2 == 0){
                System.out.println(i);
            }
        }

    }

}