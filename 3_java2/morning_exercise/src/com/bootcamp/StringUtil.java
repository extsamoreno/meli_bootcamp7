package com.bootcamp;

public class StringUtil {
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c, int n) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            builder.append(c);
        }

        return builder.toString();
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s, int n, char c) {
        StringBuilder builder = new StringBuilder();
        int remainingAmount = n - s.length();

        builder.append(replicate(c, remainingAmount));

        return builder.append(s).toString();
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[]) {
        String[] sArray = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            sArray[i] = String.valueOf(arr[i]);
        }

        return sArray;
    }

    // Retorna un int[] conteniendo los elementos de arr
    // representados como enteros
    public static int[] toIntArray(String arr[]) {
        int[] iArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            iArray[i] = Integer.parseInt(arr[i]);
        }

        return iArray;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[]) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (max <= arr[i].length()) {
                max = arr[i].length();
            }
        }

        return max;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[], char c) {
        int maxLength = maxLength(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = lpad(arr[i], maxLength, c);
        }
    }

    //idem lpad, pero agregando caracteres a la derecha.
    public static String rpad(String s, char c, int n) {
        StringBuilder builder = new StringBuilder();
        int remainingAmount = n - s.length();

        builder.append(replicate(c, remainingAmount));

        return s.concat(builder.toString());
    }

    // Retorna una cadena idéntica a s pero sin espacios a la izquierda.
    public static String ltrim(String s) {
       return s.replaceAll("^\\s+", "");
    }

    //idem ltrim, pero sin espacios a la derecha.
    public static String rtrim(String s) {
        return s.replaceAll("\\s+$", "");
    }

    // idem lpad, pero sin espacios a derecha ni izquierda.
    public static String trim(String s) {
        return s.trim();
    }

    public static int indexOfN(String s, char c, int n) {

        int cantApariciones = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                cantApariciones++;
            }

            if (cantApariciones == n) {
                return i;
            }
        }

        return -1;
    }
}
