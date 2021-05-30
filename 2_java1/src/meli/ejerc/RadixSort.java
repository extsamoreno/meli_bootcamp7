package meli.ejerc;

import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort
{

    public static void radixSort(int []arr)
    {
        String[] strArr = StringUtil.toStringArray(arr);

        StringUtil.lNormalize(strArr,'0');

        HashMap<Integer, ArrayList<String>> hm = new HashMap();

        int digitQty = strArr[0].length();

        for(int i=0;i<digitQty;i++){

            for (int j = 0; j < 10; j++) {
                hm.put(j, new ArrayList<String>());
            }

            for (int k = 0; k < strArr.length; k++) {
                int d = strArr[k].charAt(digitQty -1 - i)-'0';
                hm.get(d).add(strArr[k]);
            }
            mergeLists(strArr,hm);

        }

        for(int j=0;j<arr.length;j++){
            arr[j] = Integer.parseInt(strArr[j]);
        }
    }

    private static void mergeLists(String[] arr,HashMap<Integer,ArrayList<String>> hm){
        int k=0;
        for(int i=0; i<10; i++)
        {
            ArrayList<String> x = hm.get(i);
            for(int j=0; j<x.size(); j++)
            {
                arr[k++]=x.get(j);
            }
        }
    }

    public static void main(String[] args)
    {
        int arr[]={16223,999999999,898,13,906,235,23,9,1532,6388,2511,8,9999999};

        radixSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
