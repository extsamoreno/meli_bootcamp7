package javauno;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String myStr = Character.toString(c);
        return myStr.repeat(n);
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        return replicate(c, n) + s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String[] strArr = new String[arr.length];
        for (int i=0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }
        return strArr;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int[] intArr = new int[arr.length];
        for (int i=0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        return intArr;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        // Array de largo de caracteres
        int[] lengthArray = new int[arr.length];
        for (int i = 0; i<arr.length; i++) {
            lengthArray[i] = arr[i].length();
        }

        // Saco el máximo
        int max = lengthArray[0];
        for (int i = 1; i<lengthArray.length; i++) {
            if(lengthArray[i] > max) max = lengthArray[i];
        }
        return max;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c)
    {
        int n;
        int longitud = maxLength(arr);
        for (int i = 0; i<arr.length; i++) {
            n = longitud - arr.length;
            arr[i] = lpad(arr[i], n, c);
        }
    }
}
/*for (int i = 0; i < 9; i++) {
		myHash.put(i, new ArrayList<String>());
		}
		*/
