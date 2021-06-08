package com.company;

public class StringUtil {

    public static String[] intArrayToStringArray(int[] intArray){
        String[] salida = new String[intArray.length];
        for (int i = 0; i < intArray.length; i++){
            salida[i] = String.valueOf(intArray[i]);
        }
        return salida;
    }

    public static int maxLongitudElementoStringArray(String[] stringArray) {
        int mayorLongitud = 0;
        for (String elemento: stringArray) {
            if (elemento.length() > mayorLongitud) mayorLongitud = elemento.length();
        }
        return mayorLongitud;
    }

    public static String lpad(String cadena, int longitud, char caracter){
        String caracteres = replicate(caracter, longitud - cadena.length());
        cadena = caracteres.concat(cadena);
        return cadena;
    }

    public static void normalizarElementosStringArray(String[] stringArray, char caracter){
        int mayorLongitud = maxLongitudElementoStringArray(stringArray);
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = lpad(stringArray[i], mayorLongitud, caracter);
        }
    }

    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String caracter = String.valueOf(c);
        String salida = "";
        for (int i = 0; i < n; i++) salida = salida.concat(caracter);
        return salida;
    }

    // Retorna un int[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int[] salida = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            salida[i] = Integer.parseInt(arr[i]);
            System.out.println(salida[i]);
        }
        return salida;
    }

}