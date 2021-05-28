package PracticTT;

import java.util.ArrayList;

public class StringUtil {
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c, int n) {
        //Implementación
        String salida = "";
        for (int i = 0; i < n; i++) {
            salida += c;
        }
        return salida;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s, int n, char c) {
        //Implementación
        return replicate(c, (n - s.length())) + s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[]) {
        //Implementación
        String[] sarr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sarr[i] = String.valueOf(arr[i]);
        }
        return sarr;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[]) {
        //Implementación
        int[] iarr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            iarr[i] = Integer.parseInt(arr[i]);
        }
        return iarr;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[]) {
        //Implementación
        int cont = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > cont)
                cont = arr[i].length();
        }
        return cont;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[], char c) {
        //Implementación
        int n = maxLength(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i]=lpad(arr[i], n, c);
        }
    }
}

