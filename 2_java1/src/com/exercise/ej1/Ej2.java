package com.exercise.ej1;

import java.util.Scanner;

public class Ej2 {
    public static void ej2() {
        int nNum, mNum, mNumAux;
        System.out.println("*Ej2* Muestra los primeros n multiplos de m\n");
        Scanner num = new Scanner(System.in);
        System.out.println("Ingrese numero n");
        nNum= num.nextInt();
        System.out.println("Ingrese numero m");
        mNum= num.nextInt();
        mNumAux = mNum;
        for(int i=1;i<=nNum;i++){
            /*if(mNumAux * i == 0) */System.out.println("los primeros " +nNum+" multiplos de "+mNum+"son:" + i*mNumAux);
        }
            // n = 10 y m = 5
            // primeros n multiplos de m
            // 1) multiplo = resto 0


    }
}
