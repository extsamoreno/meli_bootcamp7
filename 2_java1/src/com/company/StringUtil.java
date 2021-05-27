package com.company;

import java.util.ArrayList;

public class StringUtil {

        // Retorna una cadena compuesta por n caracteres c
        public static String replicate(char c,int n)
        {
            String data = new String("");
            for(int i=0;i<n;i++){
                data = data+c;
            }
            return data;
        }

        // Retorna una cadena de longitud n, compuesta por s
        // y precedida de tantos caracteres c como sea necesario
        // para completar la longitud mencionada
        public static String lpad(String s,int n,char c)
        {
            String data = new String(s);
            int dataSize = data.length();
            String newData = new String("");
            for(int i=0;i<n-dataSize;i++){
                newData.concat("0");
            }
            return newData.concat(s);
        }

        // Retorna un String[] conteniendo los elementos de arr
        // representados como cadenas de caracteres
        public static String[] toStringArray(int arr[])
        {
            String[] sArray = new String[arr.length];
            for (int i=0; i<arr.length;i++){
                sArray[i] = (String) (Integer.toString(arr[i]));
            }
           return sArray;
        }

        // Retorna un String[] conteniendo los elementos de arr
        // representados como cadenas de caracteres
        public static int[] toIntArray(String arr[])
        {
            int [] sArray = new int[arr.length];
            for (int i=0; i<arr.length;i++){
                sArray[i]=(int)(Integer.parseInt(arr[i]));
            }
            return sArray;
        }


        // Retorna la longitud del elemento con mayor cantidad
        // de caracteres del array arr
        public static int maxLength(String arr[])
        {
            String data_max = arr[0];
            for(int i=1; i< arr.length;i++){
                if ( data_max.length() < arr[i].length()){
                    data_max = arr[i];
                }
            }
            return data_max.length();
        }

        // Completa los elemento del arr agregando caracteres c
        // a la izquierda, dejando a todos con la longitud del mayor
        public static void lNormalize(String arr[],char c)
        {
            int max = maxLength(arr);
            int index = 0;

            for(String s : arr) {
                s = lpad(s, max, c);
                arr[index] = s;
                index++;
            }
        }

}
