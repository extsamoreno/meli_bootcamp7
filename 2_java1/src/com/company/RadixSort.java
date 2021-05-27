package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RadixSort {

    public static void radixSort(int []arr) {
        String[] stringArray = StringUtil.toStringArray(arr);

        StringUtil.lNormalize(stringArray,'0');

        HashMap<Integer,ArrayList<String>> maps = new HashMap<>();

        // Inicializo el HashMap en array vacios
        for(int i = 0; i < stringArray.length; i++) {
            maps.put(i, new ArrayList<>());
        }

        for(int j = stringArray[0].length() - 1; j >= 0; j--) {
            for (String s : stringArray) {
                int values = Integer.parseInt(String.valueOf(s.charAt(j)));
                maps.get(values).add(s);
            }

            int index = 0;

            for(Map.Entry<Integer,ArrayList<String>> entry : maps.entrySet()) {
                for(String s : entry.getValue()) {
                    stringArray[index] = s;
                    index++;
                }
                entry.getValue().clear();
            }
        }

        int[] intArray = StringUtil.toIntArray(stringArray);
        System.arraycopy(intArray, 0, arr, 0, intArray.length);
    }

    public static void main(String[] args) {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        System.out.println();
        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }






}
