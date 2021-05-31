package com.company;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {

        Integer arr[] = new Integer[5];
        arr[0]=27495;
        arr[1]=274;
        arr[2]=95;
        arr[3]=7495;
        arr[4]=5;

        Sorter<Integer> sorter = (Sorter<Integer>) MiFactory.getInstance("MiFactory.properties");
        Comparator<Integer> compa = (a, b) -> a-b;
        sorter.sort(arr, compa);
    }
}
