package com.ejercitacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise5 {

    private static int m;
    private static int d;

    public static List<Integer> getOccurrences() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number of occurrences");
        m = scanner.nextInt();
        System.out.println("Please enter occurrences of which number");
        d = scanner.nextInt();
        if (d > 9 || d < 0) {
            System.out.println("It must be a number between 0 and 9");
            d = scanner.nextInt();
        }
        System.out.println("Please enter how many occurences should I return");
        int n = scanner.nextInt();
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (result.size() != n) {
          if (checkOccurences(i)) {
              result.add(i);
          }
          i++;
        }
        return result;
    }

    private static boolean checkOccurences(int n) {
       char[] charArray = String.valueOf(n).toCharArray();
       int counter = 0;
       for (int i = 0; i < charArray.length; i++) {
           if (charArray[i] == d + '0') {
               counter++;
           }
       }
       if (counter == m) {
           return true;
       }
       return false;
    }
}

