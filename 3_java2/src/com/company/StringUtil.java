package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n)
	{
        String replicatedCh = Character.toString(c).repeat(n);
        return replicatedCh;
	}
	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c)
	{
	    int difference = n - s.length();
		String replicated = replicate(c, difference);
		return replicated.concat(s);
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
	    int arrLength = arr.length;
	    String[] stringArray = new String[arrLength];
        for (int i = 0; i < arrLength ; i++) {
            stringArray[i] = Integer.toString(arr[i]);
        }

        return stringArray;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
        int arrLength = arr.length;
        int[] intArray = new int[arrLength];
        for (int i = 0; i < arrLength ; i++) {
            intArray[i] = Integer.parseInt(arr[i]);
        }

        return intArray;
	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
	    int max = arr[0].length();
        for (int i = 1; i < arr.length; i++) {
            int next = arr[i].length();
            if(next > max){
                max = next;
            }
        }
        return max;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c)
	{
        int maxLength = maxLength(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length() < maxLength){
                arr[i] = lpad(arr[i], maxLength, c);
            }
        }
	}
	//public static String rpad(String s,char c,int n){}

	//public static String ltrim(String s)

	//public static String rtrim(String s){}
	//public static String trim(String s){}
	//public static int indexOfN(String s,char c,int n);
}
