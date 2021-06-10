package javauno;

import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort
{
    public static void radixSort(int []arr)
    {
        // Convertimos el array de int[] a String[]
        String[] strArr = StringUtil.toStringArray(arr);

        // Completamos con 0 (ceros) a la izq de cada elemento
        StringUtil.lNormalize(strArr, '0');

        // Creamos 10 listas inicialmente vacías
        HashMap<Integer, ArrayList<String>> myHashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            myHashMap.put(i, new ArrayList<String>());
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
