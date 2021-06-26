import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort {
    public static void radixSort(int []arr) {
        // convertimos el arreglo a strings
        // Ejemplo: [418, 41888] -> ["418", "41888"]
        String[] stringArray = StringUtil.toStringArray(arr);

        // me aseguro de que todos sus elementos tengan
        // la misma longitud (añadiendo ceros)
        // Ejemplo: ["418", "41888"] -> ["00418", "41888"]

        StringUtil.lNormalize(stringArray, '0');

        // inicializamos un hashmap
        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();

        // tomo la cantidad de dígitos que todos los elementos de la lista
        // deben tener
        int digitsLength = stringArray[0].length(); // 5

        for (int i = 0; i < digitsLength; i++) {
            // inicializa el diccionario con 10 listas vacías, del 0 al 9
            initializeHashMap(hashMap);

            // ["00418", "41889", "00007", "11644"]  i = 0
            // 5 - 1 - 0 = 4
            int digitIndex = digitsLength - 1 - i; // 4
            for (int j = 0; j < stringArray.length; j++) { // 0
                int digit = stringArray[j].charAt(digitIndex) - '0'; // 8
                hashMap.get(digit).add(stringArray[j]);
            }
            restoreArray(stringArray, hashMap);
        }

        int[] integerArray = StringUtil.toIntArray(stringArray);

        for (int l = 0; l < integerArray.length; l++) {
            arr[l] = integerArray[l];
        }

    }

    public static void initializeHashMap (HashMap<Integer, ArrayList<String>> hashMap) {
        hashMap.clear();

        for (int i = 0; i < 10; i++) {
            hashMap.put(i, new ArrayList<>());
        }
    }

    public static void restoreArray(String[] stringArray, HashMap<Integer, ArrayList<String>> hashMap) {
        int k = 0;

        for (int i = 0; i < 10; i++) {
            ArrayList<String> hashedArray = hashMap.get(i);

            for (int j = 0; j < hashedArray.size(); j++) {
                stringArray[k++] = hashedArray.get(j);
            }

            /* hashMap.get(0)
             key    value
            * 0, "310", "010", "120"
              1, "111", "001"
            * */

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
