package com.company;

import java.util.Scanner;

public class Ejercicio3 {
    // Ejercicio 3 numero primo o o no
    public static Boolean esPrimo(int n){
        int i=1,diviores =0;
        for(;i<=n;i++){
            if(n%i==0)diviores++;
        }
        if (diviores==2) return true;
        else return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese numero, para saber si es o no primo");
        int num = sc.nextInt();
        System.out.println(esPrimo(num));
    }
}
