package com.company.ej2;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Sorter c = (Sorter)MiFactory.getInstance("sorter");
        Integer arr[] = {1,2,5,2,29,6,5};
        Comparator<Integer> comp = (a, b)->a-b;
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
        System.out.println();
        c.sort(arr, comp);

        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }
}
