package com.company;

import java.util.Scanner;

public class ExerciseThree {
    public static void isPrimeNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el numero a verificar si es primo: ");
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {

            if(n % i == 0){
                count ++;
            }
            if(count > 2){
                System.out.println("El numero no es primo");
                break;
            }
        }
        if(count <= 2) {
            System.out.println("El numero es primo");
        }
    }

    public static void main(String[] args)
    {
        isPrimeNumber();
    }
}
