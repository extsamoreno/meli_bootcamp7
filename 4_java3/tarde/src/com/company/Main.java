package com.company;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Sorter<String> o = (Sorter) MiFactory.getInstance("MiFactory.properties");

        String[] arr_str = new String[3];
        arr_str[0] = "Juan";
        arr_str[1] = "Roberto";
        arr_str[2] = "Donatelo";

        for (int i = 0; i < arr_str.length; i++) {
            System.out.println(arr_str[i]);
        }

        Comparator<String> c1 = ((o1, o2) -> o1.compareTo(o2));

        o.sort(arr_str, c1);

        for (int i = 0; i < arr_str.length; i++) {
            System.out.println(arr_str[i]);
        }
    }
}
