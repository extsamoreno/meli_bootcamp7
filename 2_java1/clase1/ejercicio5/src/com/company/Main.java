//Desarrollar un programa para mostrar por consola los primeros n números naturales que tienen al menos m dígitos d, siendo n, m y d valores que el usuario ingresará por consola.

package com.company;

import java.util.Scanner;

public class Main {

    public static void obtenerNum(int n, int m, int d){
        int totalNum =0, countm=0,i=1,num=1;
        while(totalNum!=n){
            num=i;
            while(num!=0){
                if(num%10==d) countm++;
                num=num/10;
            }
            if(countm >= m){
                System.out.println(i);
                totalNum++;
            }
            countm=0;
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese n");
        int n = sc.nextInt();
        System.out.println("Ingrese m");
        int m = sc.nextInt();
        System.out.println("Ingrese d");
        int d = sc.nextInt();
        obtenerNum(n,m,d);
    }
}
