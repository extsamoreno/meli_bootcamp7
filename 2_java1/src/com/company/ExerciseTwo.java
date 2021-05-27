package com.company;

import java.util.Scanner;

public class ExerciseTwo {

    public static void isMultiple(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de multiplos a mostrar: ");
        int n = scanner.nextInt();

        System.out.print("Ingrese el numero a calcular multiplos: ");
        int m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int multiple = i * m;
            if(multiple % m == 0){
                System.out.println(multiple);
            }
        }
    }
    public static void main(String[] args)
    {
        isMultiple();
    }
}
