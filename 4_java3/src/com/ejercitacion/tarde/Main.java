package com.ejercitacion.tarde;

import java.io.IOException;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        Sorter s = (Sorter) MiFactory.getInstance("sorter");

        Integer[] iArr = {5,3,0,2,6,9,2};
        System.out.println(iArr);
        Comparator<Integer> c1 = (a,b) -> a-b;
        s.sort(iArr,c1);
        System.out.println(iArr);

//        String[] sArr = {"z", "l", "q", "a", "m"};

    }
}