package ejercitacion_tarde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RadixSort {

    public static void radixSort(int[] arr) {

        // Convertir el arreglo de int[] a String[].
        String sArr[] = StringUtil.toStringArray(arr);

        // Normalizar
        StringUtil.lNormalize(sArr, '0');

        // Crear 10 listas vacías
        HashMap<String, ArrayList<String>> lists = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            lists.put("L" + i, new ArrayList<String>());
        }

        int maxCantDigitos = (sArr[0].length());

        while (maxCantDigitos > 0) {

            for (int i = 0; i < sArr.length; i++) {
                char aux = sArr[i].charAt(maxCantDigitos - 1);
                lists.get("L" + aux).add(sArr[i]);
            }

            int i = 0;
            for (Map.Entry<String, ArrayList<String>> entry : lists.entrySet()) {
                ArrayList<String> value = entry.getValue();

                for (String number : value) {
                    sArr[i] = number;
                    i++;
                }
                value.clear();
            }

            maxCantDigitos--;

        }

        for (int i = 0; i < sArr.length; i++) {
            arr[i] = Integer.parseInt(sArr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {34, 45, 1, 3, 546, 56, 6785764, 23, 134};
        radixSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }

    }
}
