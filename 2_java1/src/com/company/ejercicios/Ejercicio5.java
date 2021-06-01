package com.company.ejercicios;

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        int i=0;
        int contador=0;

        while( contador<n ) {

            if( cumpleCondicion(i,m,d) ) {
                contador++;
                System.out.println(i);
            }

            i++;
        }

    }

    public static int digitCount(String s, char c){
        int i=0;
        int contador=0;

        while( i<s.length() ) {

            if( s.charAt(i)==c) {
                contador++;
            }

            i++;
        }

        return contador;
    }

    public static boolean cumpleCondicion(int n,int m,int d){
        return digitCount(Integer.toString(n),(char)(d+'0'))==m;
    }

}
