package com.meli;

import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort {

    public static void radixSort(int []arr) {
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        String[] arrayString;
        int [] auxArray;
        int lastIndex;

        arrayString = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(arrayString, '0');

        StringUtil.makeTenList(map);

        lastIndex = arrayString[0].length() - 1;

        for(int i = lastIndex ; i >= 0 ; i--) {
            StringUtil.convertToList(arrayString, map, i);
            StringUtil.chargeNewData(arrayString, map);
            StringUtil.clearAllLists(map);
        }

        auxArray= StringUtil.toIntArray(arrayString);

        System.arraycopy(auxArray, 0, arr, 0, auxArray.length);
    }

    public static void main(String[] args) {
        //int arr [] = { 4, 28, 132, 3, 61, 5 };
        //int arr [] = { 3, 673, 106, 45, 2,23 };
        int[] arr={ 16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8 };

        radixSort(arr);

        for(int i=0 ; i<arr.length ; i++) {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }
}
