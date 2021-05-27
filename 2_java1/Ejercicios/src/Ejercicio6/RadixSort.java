package Ejercicio6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RadixSort {

    public static void main(String[] args) {

        //int arr[] = {16223,898,13,906,235,23,9,1532,6388,2511,8};
        int arr[] = {3, 673, 106, 45, 2, 23 };

        radixSort(arr);

        for(int i=0 ; i<arr.length ; i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }

    public static void radixSort(int []arr)
    {
        String[] arrStr;
        arrStr = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(arrStr, '0');

        HashMap<Integer, ArrayList<String>> hmap = new HashMap<>();

        // Crear listas vacias
        for(int i = 0 ; i < 10 ; i++){
            hmap.put(i, new ArrayList<String>());
        }

        int lastNum = 0;
        int maxLenght = StringUtil.maxLength(arrStr);

        // Llenar los maps y ordenar
        for(int j = arrStr[0].length() - 1; j >= 0; j--) {
            for (String s : arrStr) {
                int key = Integer.parseInt(String.valueOf(s.charAt(j)));
                hmap.get(key).add(s);
            }

            int index = 0;

            for(Map.Entry<Integer,ArrayList<String>> entry : hmap.entrySet()) {
                for(String s : entry.getValue()) {
                    arrStr[index] = s;
                    index++;
                }
                entry.getValue().clear();
            }
        }

        int[] intArray = StringUtil.toIntArray(arrStr);
        System.arraycopy(intArray, 0, arr, 0, intArray.length);
    }
}



// Mostrar array
        /*for(int i=0 ; i<arr.length ; i++)
        {
            System.out.print(arrStr[i]+(i<arrStr.length-1?",":""));
        }*/

// Character.getNumericValue(number.charAt(number.length()-1-i));
// hmap.get(key).add(str)