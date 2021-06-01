package com.company.ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(var i = 2; i <= n; i++){
            if(esPrimo(i)){
                System.out.println(i);
            }
        }


    }

    public static boolean esPrimo(int n){
        boolean esPrimo = true;

        for(var i = 2; i < n; i++){
            if(n % i == 0){
                esPrimo = false;
            }
        }

        if(!esPrimo){
            return false;
        } else {
            return true;
        }
    }

}
