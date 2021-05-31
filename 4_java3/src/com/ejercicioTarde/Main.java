package com.ejercicioTarde;

import java.io.IOException;
import java.util.Comparator;
import java.lang.reflect.*;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Sorter sQuick = (Sorter<Integer>)  MiFactory.getInstance("QuickSortSorterImple");
        Sorter sBubble = (Sorter<Integer>)  MiFactory.getInstance("BubbleSortSorterImple");
        Sorter sHeap = (Sorter<Integer>)  MiFactory.getInstance("HeapSortSorterImple");

        Comparator<Integer> c1 = (a, b) -> a - b;

        var Arr1 = createArr1000();
        var Arr2 = createArr1000();
        var Arr3 = createArr1000();

        timeSortAndPrint(Arr1, c1, sQuick);
        System.out.println("Time sQuick:"+Timer.elapsedTime());

        timeSortAndPrint(Arr2, c1, sBubble);
        System.out.println("Time sBubble:"+Timer.elapsedTime());

        timeSortAndPrint(Arr3, c1, sHeap);
        System.out.println("Time sHeap:"+Timer.elapsedTime());


    }

    public static void timeSortAndPrint(Integer[] arr, Comparator<Integer> c, Sorter<Integer> s){
        mostrarArr(arr);
        Timer.start();
        s.sort(arr, c);
        Timer.stop();
        mostrarArr(arr);
    }

    public static Integer[] createArr1000() {
        Integer[] iArr1000 = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            iArr1000[999-i] = i;
        }
        return  iArr1000;
    }

    public static <T> void mostrarArr(T[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println("//");
    }


}

