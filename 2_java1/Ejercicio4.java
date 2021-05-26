package com.company;

import java.util.Scanner;

public class Ejercicio4 {
    // Ejercicio4 Listar n num primos

    public static Boolean esPrimo(int n){
        int i=1, diviores =0;
        for(;i<=n;i++){
            if(n%i==0)diviores++;
        }
        if (diviores==2) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite la cantidad de numeros primos que desea ver");
        int num = sc.nextInt();
        int count=0, i=0;
        while (count != num){
            if(esPrimo(i)){
                System.out.println(i);
                count++;
            }
            i++;
        }
    }
}
