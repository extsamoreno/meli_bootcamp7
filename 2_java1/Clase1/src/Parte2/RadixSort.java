package Parte2;

import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort {
    public static HashMap<Integer, ArrayList<String>> lists;

        public static void radixSort(int[] arr)
        {
            createMap();

            String[] newArray = new String[arr.length];
            newArray = StringUtil.toStringArray(arr);
            int n = StringUtil.maxLength(newArray);

            String s = "0";
            char ch = s.charAt(0);
            StringUtil.lNormalize(newArray, ch);

            for (int i = n; i != 0 ; i--) {
                AddList(newArray, i);
                newArray = GenerateArray(newArray.length);
                lists.clear();
                createMap();
            }

            arr = StringUtil.toIntArray(newArray);
        }

    private static void createMap() {
        lists = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            lists.put(i, new ArrayList<>()); }
    }


    public static String[] GenerateArray(int longitud){
        int i = 0;
        String[] string = new String[longitud];
        for (var entry: lists.entrySet()) {
            for (String valor : entry.getValue()) {
                string[i]  = valor;
                i++;
            }
        }
        return string;
    }


    public static void AddList(String[] arr, int longitud){
        for (String s: arr) {
            char ch1 = s.charAt(longitud-1);
            ArrayList list = lists.get(Character.getNumericValue(ch1));
            list.add(s);
            lists.put(Character.getNumericValue(ch1), list);
        }
    }


    public static void main(String[] args)
    {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

            for(int i=0; i<arr.length;i++)
            {
                System.out.print(arr[i]+(i<arr.length-1?",":""));
            }
    }
}
