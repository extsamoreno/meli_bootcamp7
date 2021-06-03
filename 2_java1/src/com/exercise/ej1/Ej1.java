package com.exercise.ej1;

import java.util.Scanner;

public class Ej1 {
    public static void ej1() {
        /*Scanner qNum = new Scanner(System.in);
        int qNumInt;
        System.out.println("*EJ1* (Se considera al cero como numero par)\n");
        System.out.println("Ingrese el numero: \n");
        qNumInt= qNum.nextInt();
        int inValue = qNumInt;
        for (int n = 0; n <= inValue; n++) {
            if (qNumInt % 2 == 0) System.out.println("Numero par: \n" +qNumInt);
            qNumInt--;*/
        String[] array = new String[4];
        array[0] = "0";
        array[1] = "1";
        array[2] = "2";
        array[3] = "3";
        removeIndex(array, array.length-1);
        System.out.println("El array es: \n"+array[0]);
        System.out.println("El array es: \n"+array[1]);
        System.out.println("El array es: \n"+array[2]);
        System.out.println("El array es: \n"+array[3]);
    }

    private static void removeIndex(String[] array, int index) {
        int i = index;
        for (; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[i] = null;
    }

}






