
package Eje1;
import Eje1.StringUtil;

import java.util.ArrayList;

public class RadixSort {

    public static void radixSort(int[] arr) {
        String[] arrString = new String[arr.length];
        int maxLength;
        char digito;
        int lista;
        int posicion;

        ArrayList[] listas = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            listas[i] = new ArrayList();
        }

        arrString = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(arrString, '0');
        maxLength = arrString[0].length();

        for (int p = maxLength - 1; p >= 0; p--) { // recorriendo la posicion dentro de cada elemento del array

            for (int e = 0; e < arrString.length; e++) {
                digito = arrString[e].charAt(p);
                lista = digito - 48;

                listas[lista].add(arrString[e]);

            }
            posicion = 0;
            for (int j = 0; j < 10; j++) {

                for (int k = 0; k < listas[j].size(); k++) {
                    arrString[posicion] = (String) listas[j].get(k);
                    posicion++;
                }
                listas[j].clear();

            }

        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(arrString[i]);
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
