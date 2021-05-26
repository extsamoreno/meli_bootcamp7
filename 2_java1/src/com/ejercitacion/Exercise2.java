package com.ejercitacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise2 {

    public static List <Integer> getMultiples() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tell me how many multiples");
        int n = scanner.nextInt();
        System.out.println("Multiples of what number?");
        int m = scanner.nextInt();
        List<Integer> result = new ArrayList<>();
        int multiplo = m + 1;
        while (result.size() != n) {
           if (multiplo % m == 0) {
               result.add(multiplo);
           }
           multiplo++;
        }
        return result;
    }

}
