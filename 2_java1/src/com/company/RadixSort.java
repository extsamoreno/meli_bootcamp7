package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RadixSort {
    public static void radixSort(int[] arr) {

        String[] stringArr = StringUtil.intArrayToStringArray(arr);
        StringUtil.normalizarElementosStringArray(stringArr, '0');
        HashMap<Integer, ArrayList<String>> listas = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            listas.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= StringUtil.maxLongitudElementoStringArray(stringArr); i++) {
            llenarLista(listas, stringArr, i);
            llenarArreglo(listas, stringArr);
        }


        for (int i = 0; i < stringArr.length; i++) {
            arr[i] = Integer.parseInt(stringArr[i]);
        }

    }

    public static void llenarLista(Map<Integer, ArrayList<String>> listas, String[] stringArr, int numeroDigito) {
        for (String s : stringArr) {
            String ultimoDigito = s.substring((s.length() - numeroDigito), (s.length() - numeroDigito + 1));
            listas.get(Integer.parseInt(ultimoDigito)).add(s);
        }
    }

    public static void llenarArreglo(Map<Integer, ArrayList<String>> listas, String[] stringArr) {
        int inicioArreglo = 0;
        for (Map.Entry<Integer, ArrayList<String>> lista : listas.entrySet()) {
            if (lista.getValue().size() > 0) {
                for (String elemento : lista.getValue()) {
                    stringArr[inicioArreglo] = elemento;
                    inicioArreglo++;
                }
                lista.getValue().clear();
            }
        }
    }


    public static void main(String[] args) {
        //int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        int arr[] = {3, 673, 106, 45, 2,23};
        radixSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
    }
}

