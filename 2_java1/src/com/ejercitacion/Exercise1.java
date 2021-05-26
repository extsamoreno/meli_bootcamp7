package com.ejercitacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise1 {

    public static List<Integer> getEvenNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer");
        int n = scanner.nextInt();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
