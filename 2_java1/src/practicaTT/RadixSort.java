package practicaTT;

import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort {
    public static void radixSort(int[] arr) {
        String[] listaDeString = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(listaDeString, '0');
        HashMap<Character, ArrayList<String>> mapaDeListas = new HashMap<Character, ArrayList<String>>();

        fillMap(mapaDeListas, 10);
        System.out.println(mapaDeListas.keySet());
        System.out.println(mapaDeListas.values());

//        for (int i = 0; i < listaDeString.length; i++) {
//            String elem=listaDeString[i];
//
//
//        }


       /* for (int i = 0; i < listaDeString.length; i++) {
            System.out.print(listaDeString[i] + (i < listaDeString.length - 1 ? "," : ""));
        }

        */

    }

    public static void fillMap(HashMap<Character, ArrayList<String>> listMap, int n) {
        for (int i = 0; i < n; i++) {
            listMap.put(Character.forDigit(i, 10), new ArrayList<String>());
        }
    }


    public static void main(String[] args) {
        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        radixSort(arr);
		/*
		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":""));
		}*/
    }
}
