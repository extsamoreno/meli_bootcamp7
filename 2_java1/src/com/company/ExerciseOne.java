package com.company;

import java.util.Scanner;

public class ExerciseOne {

    public static void isEven(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el numero deseado: ");

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args)
    {
        isEven();
    }
}
