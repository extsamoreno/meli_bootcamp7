package com.bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RadixSort {

    public static final Map<Character, ArrayList<String>> LISTS = new HashMap<>(){{
        put('0', new ArrayList<>());
        put('1', new ArrayList<>());
        put('2', new ArrayList<>());
        put('3', new ArrayList<>());
        put('4', new ArrayList<>());
        put('5', new ArrayList<>());
        put('6', new ArrayList<>());
        put('7', new ArrayList<>());
        put('8', new ArrayList<>());
        put('9', new ArrayList<>());
    }};


    public static void radixSort(int[] arr) {
        //Convertir el arreglo de ints a un arreglo de Strings
        String[] sArray = StringUtil.toStringArray(arr);

        //Normalizo el arreglo según la longitud de sus elementos
        StringUtil.lNormalize(sArray, '0');

        //Realizo una copia del arreglo de strings pero utilizando un ArrayList
        ArrayList<String> aux = new ArrayList<>(Arrays.asList(sArray));
        ArrayList<String> auxInOrder = new ArrayList<>();

        //Obtengo la posicioón del último caracter para cada string
        int lastIndex = sArray[0].length() - 1;

        //Realizo una iteración por los caracteres de cada string de derecha a izquierda
        for (int i = lastIndex; i >= 0; i--) {
            auxInOrder.clear();

            //De cada string obtengo el caracter en la posición i y lo agrego en la lista que corresponda
            //según su valor
            for (String value: aux) {
                char key = value.charAt(i);
                LISTS.get(key).add(value);
            }

            //En el arrayList auxInOrder almaceno los valores de las listas ordenados por el último caracter
            //recorrido
            LISTS.forEach((key, value) -> {
                auxInOrder.addAll(value);
                value.clear();
            });

            aux.clear();
            aux.addAll(auxInOrder);
        }

        //Transformo el ArrayList de Strings a un Array de Int's
        int[] result = StringUtil.toIntArray(auxInOrder.toArray(new String[sArray.length]));

        //Replico el resultado en el arreglo de entrada
        System.arraycopy(result, 0, arr, 0, result.length);

    }


    public static void main(String[] args) {
        int[] a = {3, 3, 33, 0 , 673, 106, 45, 2, 2300 };
        radixSort(a);

        for(int i: a) {
            System.out.println(i);
        }

    }
}
