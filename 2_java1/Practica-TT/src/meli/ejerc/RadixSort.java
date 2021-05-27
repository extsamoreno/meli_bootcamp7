package meli.ejerc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class RadixSort
{

    public static void radixSort(int[] arr) {
        String[] sArr = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(sArr, '0');

        int longitud = sArr[0].length();

        //realizo la iteracion para cada digito del array
        for (int digito = longitud - 1; digito >= 0; digito--) {
            HashMap<Integer, ArrayList<String>> map = new HashMap<>();
            for (int i = 0; i < 10; i++) {
                map.put(i, new ArrayList<>());
            }

            for (int i = 0; i < sArr.length; i++) {
                int key = Character.getNumericValue(sArr[i].charAt(digito));
                map.get(key).add(sArr[i]);
            }

            //itero el hashmap para volver cada lista al arreglo original
            int index = 0;
            for (Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
                for (int i = 0; i < entry.getValue().size(); i++) {
                    sArr[index] = entry.getValue().get(i);
                    index++;
                }
            }
            //borro el hashmap para la siguiente iteracion
            for (int i = 0; i < 10; i++) {
                map.get(i).clear();
            }
        }

        //convierto el array a int
        int[] iArr = StringUtil.toIntArray(sArr);
        for (int i = 0; i < iArr.length; i++) {
            arr[i] = iArr[i];
        }
    }

    public static void main(String[] args) {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};

        radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
           System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }
}