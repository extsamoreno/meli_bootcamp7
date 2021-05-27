package meli.ejerc;

import java.util.ArrayList;
import java.util.HashMap;

import meli.ejerc.StringUtil;

public class RadixSort {
    public static void radixSort(int[] arr) {
        //Implementación

        String[] arrayString = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(arrayString, '0');
        String[] array = new String[arr.length];
        int maxSizeString = StringUtil.maxLength(arrayString);
        for (int e = maxSizeString; e >0; e--) {
            int posicionArray = 0;
            for (int i = 0; i < 10; i++) {
                ArrayList<String> listi = new ArrayList();
                for (int k = 0; k < arrayString.length; k++) {
                    String ultimoDigito = String.valueOf(arrayString[k].charAt(e - 1));
                    String numberlist = String.valueOf(i);
                    if (ultimoDigito.equals(numberlist)) {
                        listi.add(arrayString[k]);
                    }
                }
                for (int j = 0; j < listi.size(); j++) {
                    array[posicionArray] = listi.get(j);
                    posicionArray++;
                }
            }

            for (int n = 0; n < arrayString.length; n++) {
                arrayString[n]=array[n];
            }
        }
        int[] listOrder = StringUtil.toIntArray(arrayString);
        for (int n = 0; n < listOrder.length; n++) {
            arr[n]=listOrder[n];
        }

    }


    public static void main(String[] args) {
        //int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        int arr[] = {3, 673, 106, 45, 2,23 };
        radixSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
    }
}
