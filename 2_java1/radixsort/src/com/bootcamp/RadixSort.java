package com.bootcamp;

import java.util.ArrayList;

public class RadixSort {

    public static final ArrayList<String>[] LISTS = new ArrayList[10];

    public static final ArrayList<String> L0 = new ArrayList<>();
    public static final ArrayList<String> L1 = new ArrayList<>();
    public static final ArrayList<String> L2 = new ArrayList<>();
    public static final ArrayList<String> L3 = new ArrayList<>();
    public static final ArrayList<String> L4 = new ArrayList<>();
    public static final ArrayList<String> L5 = new ArrayList<>();
    public static final ArrayList<String> L6 = new ArrayList<>();
    public static final ArrayList<String> L7 = new ArrayList<>();
    public static final ArrayList<String> L8 = new ArrayList<>();
    public static final ArrayList<String> L9 = new ArrayList<>();


    public static void radixSort(int[] arr) {
        //Convertir el arreglo de ints a un arreglo de Strings
        String[] sArray = StringUtil.toStringArray(arr);

        //Normalizar el arreglo según la longitud de sus elementos
        StringUtil.lNormalize(sArray, '0');


        int lastIndex = sArray[0].length() - 1;

        for (int i = 0; i < sArray.length; i++) {
            LISTS[sArray[i].charAt(lastIndex)].add(sArray[i]);
        }

        System.out.println();


    }

    public static void main(String[] args) {
        int[] a = {3, 673, 106, 45, 2, 23 };
        radixSort(a);

        for(int i: a) {
            System.out.println(i);
        }

    }
}
