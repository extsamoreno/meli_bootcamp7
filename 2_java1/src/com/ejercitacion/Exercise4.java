package com.ejercitacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise4 {

    public static List<Integer> getPrimeNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many prime numbers do you want?");
        int n = scanner.nextInt();
        List<Integer> result = new ArrayList<>();
        int i = 1;
        while (result.size() != n) {
           if (isPrime(i)) result.add(i);
           i++;
        }
        return result;
    }

    public static boolean isPrime(int n) {
       for (int i = 2; i < n; i++) {
          if(n % i == 0) {
              return false;
          }
       }
       return true;
    }
}
