//EJERCICIO 4: Desarrollar un programa para mostrar por consola los primeros n números primos, siendo n un valor que el usuario ingresará por consola.

package com.company;

import java.util.Scanner;

public class Main{


    public static Boolean nPrimo(int n){
        int i=1, div =0;
        for(;i<=n;i++){
            if(n%i==0)div++;
        }
        if (div==2) return true;
        else return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("índique cuantos nros primos quiere ver..");
        int num = sc.nextInt();
        int count=0, i=0;
        while (count != num){
            if(nPrimo(i)){
                System.out.println(i);
                count++;
            }
            i++;
        }
    }
}