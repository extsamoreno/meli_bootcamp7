package functions;

import java.util.ArrayList;

public class StringUtils
{
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        //Implementación
        String strReplicatedChar = "";
        for (int i = 0; i < n; i++) {
            strReplicatedChar += c;
        }
        return strReplicatedChar;


    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        //Implementación
        return replicate(c ,n - s.length()) + s;

    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int[] arr)
    {
        //Implementación
        String[] myStrArr = new String[arr.length];
        for (int i=0; i<arr.length; i++){
            myStrArr[i] = Integer.toString(arr[i]);
        }
        return myStrArr;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String[] arr)
    {
        //Implementación
        int[] myIntArr = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            myIntArr[i] = Integer.parseInt(arr[i]);
        }
        return myIntArr;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String[] arr)
    {
        //Implementación
        int maxLen = 0;
        for (String s : arr) {
            if (s.length() > maxLen) {
                maxLen = s.length();
            }
        }
        return maxLen;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String[] arr,char c)
    {
        //Implementación
        int maxStrLen = maxLength(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = lpad(arr[i], maxStrLen, c);
        }
    }
}
