package PracticTT;

import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort {
    public static void radixSort(int[] arr) {
        //Implementación
        //Implementamos conversion de los enteros a String para poder tratarlos
        String[] sarr = StringUtil.toStringArray(arr);
        //normalizamos los datos
        StringUtil.lNormalize(sarr, '0');




        //Me encuentro estudiando el manejo de los HashMap dado que tengo dudas sobre este.
        //dudas sobre como cambia el apuntador
        HashMap<Integer, ArrayList<String>> ed = new HashMap<>();
        int cantDig = sarr[0].length();
        for (int i = 0; i < cantDig; i++) {
            // agrega 10 entradas, de 0 a 9, con arraylists vacios
            inicializarED(ed);
            int digPos = cantDig - 1 - i;
            for (int j = 0; j < sarr.length; j++) {
                int d = sarr[j].charAt(digPos) - '0';
                ed.get(d).add(sarr[j]);
            }
            rearmarArray(sarr, ed);
        }
        int iArr[] = StringUtil.toIntArray(sarr);
        for (int x = 0; x < iArr.length; x++) {
            arr[x] = iArr[x];
        }
    }
    private static void rearmarArray(String[] sArr, HashMap<Integer, ArrayList<String>> ed) {
        int k = 0;
        for (int i = 0; i < 10; i++) {
            ArrayList<String> x = ed.get(i);
            for (int j = 0; j < x.size(); j++) {
                sArr[k++] = x.get(j);
            }
        }
    }

    private static void inicializarED(HashMap<Integer, ArrayList<String>> ed) {
        ed.clear();
        for (int i = 0; i < 10; i++) {
            ed.put(i, new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        radixSort(arr);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
    }
}