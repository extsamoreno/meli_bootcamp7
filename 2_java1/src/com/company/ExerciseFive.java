package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExerciseFive {

    public static void PrintNNaturals(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de numeros a mostrar: ");
        int n = scanner.nextInt();

        System.out.print("Ingrese la cantidad de digitos: ");
        int m = scanner.nextInt();

        System.out.print("Ingrese el digito: ");
        int d = scanner.nextInt();

        int initialValue = (d * 10) + d;
        int count = initialValue;
        int i = 0;

        while (i != n){
            char[] numberArray = Integer.toString(count).toCharArray();
            Arrays.sort(numberArray);
            String stringArray = new String(numberArray);
            if(stringArray.startsWith(Integer.toString(initialValue)) || stringArray.endsWith(Integer.toString(initialValue))){
                System.out.println(count);
                i++;
            }
            count ++;
        }

    }
    public static void main(String[] args)
    {
        PrintNNaturals();
    }
}
