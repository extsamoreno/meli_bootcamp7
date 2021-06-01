package com.company.ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(var i = 0; i < n; i++){
            System.out.println(m*i);
        }

    }
}
