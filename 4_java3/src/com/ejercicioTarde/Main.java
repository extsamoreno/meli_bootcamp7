package com.ejercicioTarde;

import java.io.IOException;
import java.util.Comparator;
import java.lang.reflect.*;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Sorter s = (Sorter<Integer>)  MiFactory.getInstance("sorter");

        Integer[] iArr = {5, 3, 0, 2, 6, 9, 2};
        mostrarArr(iArr);
        Comparator<Integer> c1 = (a, b) -> a - b;
        s.sort(iArr, c1);
        mostrarArr(iArr);

        Integer[] iArr1000 = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            iArr1000[999-i] = i;
        }
        mostrarArr(iArr1000);
        Timer.start();
        s.sort(iArr1000, c1);
        Timer.stop();
        var time = Timer.elapsedTime();
        mostrarArr(iArr1000);
        System.out.println("Time:"+time);System.out.println("Time:"+time);
    }

    public static <T> void mostrarArr(T[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }


}

