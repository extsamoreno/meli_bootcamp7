package ejercicio6;

import java.util.ArrayList;
import java.util.HashMap;

public class radixSort {
    public static void radixSort(int []arr){
        String stringArray[] = ejercicio6.StringUtil.toStringArray(arr);

        ejercicio6.StringUtil.lNormalize(stringArray,'0');

        HashMap<Integer,ArrayList<String>> ed = new HashMap<>();


        int cantDigitos = stringArray[0].length();
        for(int i=0; i<cantDigitos; i++){
            ed.clear();
            for(int j=0; j<10; j++){
                ed.put(j,new ArrayList<>());
            }

            int digitoPosterior = cantDigitos-1-i;
            for(int k=0; k<stringArray.length; k++){
                int digito = stringArray[k].charAt(digitoPosterior)-'0';
                ed.get(digito).add(stringArray[k]);
            }

            int l=0;
            for(int m=0; m<10; m++){
                ArrayList<String> x = ed.get(m);
                for(int n=0; n<x.size(); n++){
                    stringArray[l++]=x.get(n);
                }
            }
        }

        int intArr[]= ejercicio6.StringUtil.toIntArray(stringArray);
        for(int o=0; o<intArr.length;o++){
            arr[o]=intArr[o];
        }
    }

    public static void main(String[] args){
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }
}