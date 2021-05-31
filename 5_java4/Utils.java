package com.company.Clase4Java;

import java.util.List;

public class Utils {

    public static <T> void printArr(List<T> arr) {
        for (T t : arr) {
            System.out.print(t.toString() + " ");
        }
        System.out.println(" ");

    }
}