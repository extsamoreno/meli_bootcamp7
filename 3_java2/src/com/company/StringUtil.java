package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StringUtil {
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n)
	{
		String myString = "";
		while(n >0){
			myString +=c;
			n--;
		}
		return myString;
	}

	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c)
	{
		String myString = s;
		while(myString.length() < n){
				myString = c+myString;
		}
		return myString;
	}

	//idem lpad, pero agregando caracteres a la derecha.
	public static String rpad(String s,int n,char c)
	{
		String myString = s;
		while(myString.length() < n){
			myString = myString + c;
		}
		return myString;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		String myString[] = new String[arr.length];
		for(int i =0; i< arr.length; i++){
			myString[i] = String.valueOf(arr[i]);
		}
		return myString;

	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		int myInt[] = new int[arr.length];
		for(int i =0; i< arr.length; i++){
			myInt[i] = Integer.parseInt(arr[i]);
		}
		return myInt;
	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		int maxLength = 0;

		for (String s : arr) {
			if (s.length() > maxLength) {
				maxLength = s.length();
			}
		}

		return maxLength;
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

	//Retorna una cadena idéntica a s pero sin espacios a la izquierda.
	public static String ltrim(String s){
		int i = 0;
		while(i < s.length() && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		return s.substring(i);
	}

	//idem ltrim, pero sin espacios a la derecha.
	public static String rtrim(String s){
		int i = s.length() - 1;
		while(i >= 0 && Character.isWhitespace(s.charAt(i))) {
			i--;
		}
		return s.substring(0,i+1);
	}

	public static String trim(String s) {
		s = ltrim(s);
		s = rtrim(s);
		return s;
	}

	public static int indexOfN(String s, char c, int n) {
		int index = -1;
		int i = 0;
		int occurrences = 0;

		while (i < s.length() && occurrences != n) {
			if(s.charAt(i) == c) {
				index = i;
				occurrences++;
			}
			i++;
		}
		return index;
	}
}
