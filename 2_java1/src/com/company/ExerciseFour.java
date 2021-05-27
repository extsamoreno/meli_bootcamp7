package com.company;

import java.util.Scanner;

public class ExerciseFour {
    public static void GetNPrimes(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el numero a mostrar los n primos: ");
        int n = scanner.nextInt();
        int i = 0;
        int number = 1;
        while(i != n){
            if(isPrimeNumber(number)){
                System.out.println(number);
                i++;

            }
            number++;
        }
    }

    public static boolean isPrimeNumber(int n){
        int count = 0;
        boolean isPrime = true;
        for (int i = 1; i <= n; i++) {
            if(n % i == 0){
                count ++;
            }
            if(count > 2){
                isPrime = false;
                return isPrime;
            }
        }
        return isPrime;
    }

    public static void main(String[] args)
    {
        GetNPrimes();
    }
}
