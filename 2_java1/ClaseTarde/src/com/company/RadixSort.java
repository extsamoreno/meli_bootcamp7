package com.company;

public class RadixSort {

    public static void radixSort(int []arr)
    {
        String[] Lista= StringUtil.toStringArray(arr);
        StringUtil.lNormalize(Lista,'0');


        for (int i = Lista[1].length()-1; i >=0; i--) {
            Lista= StringUtil.hash(Lista,i);
        }
        System.out.println();
        System.out.println("Vector con 0");
        for(int j=0; j<Lista.length;j++)
        {
            System.out.print(Lista[j]+(j<Lista.length-1?",":""));
        }
        System.out.println();
        System.out.println("Vector final");
        int []VectorFi=StringUtil.toIntArray(Lista);

        for(int j=0; j<VectorFi.length;j++)
        {
            System.out.print(VectorFi[j]+(j<VectorFi.length-1?",":""));
        }


    }






    public static void main(String[] args) {
        int arr[]={3, 673, 106, 45, 2,23};
        //int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        System.out.println("Vector inicial");
        for(int j=0; j<arr.length;j++)
        {
            System.out.print(arr[j]+(j<arr.length-1?",":""));
        }
        radixSort(arr);

    }
}
