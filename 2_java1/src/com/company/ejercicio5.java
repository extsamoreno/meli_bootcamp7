package com.company;

import java.util.Scanner;
import java.lang.String;

public class ejercicio5 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de números:");
        int cantNaturales = scan.nextInt();

        System.out.println("Ingrese el número que quiere que contenga los nros. naturales:");
        int num = scan.nextInt();
        char charToCompare = Integer.toString(num).charAt(0);

        System.out.println("Ingrese la cantidad de veces que quiere que se repita ese nro. en cada nro. natural:");
        int cantRepeticion = scan.nextInt();

        int auxCantNaturales = 0;
        int i = 0;

        while(auxCantNaturales < cantNaturales){

            String number = Integer.toString(num);
            int auxCantRepeticiones = 0;
            String nro = Integer.toString(i);

            for (int j = 0; j < nro.length() ; j++) {
                char charCurrent = nro.charAt(j);

                if(charCurrent == charToCompare)
                    auxCantRepeticiones++;

                if(auxCantRepeticiones >= cantRepeticion) {
                    auxCantNaturales++;
                    System.out.println(i);
                }
            }
        i++;
        }


    }
}
