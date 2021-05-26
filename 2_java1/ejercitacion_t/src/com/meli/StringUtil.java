package com.meli;

import java.util.Arrays;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n) {
		String zeroString = "";
		for (int i = 0; i < n; i++) {
			zeroString += c;
		}

		return zeroString;
	}
	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c) {
		int lengthDiff = n - s.length();

		if(lengthDiff > 0) {
			s = replicate(c,lengthDiff)+s;
		}

		return s;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[]) {
		String[] stringArray = new String[arr.length];

		for(int i = 0; i < arr.length; i++) {
			stringArray[i] = String.valueOf(arr[i]);
		}
		return stringArray;
	}

	// Retorna un int[] conteniendo los elementos de arr
	// representados como cadenas de caracteres
	public static int[] toIntArray(String arr[]) {
		int[] intArray = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			intArray[i] = Integer.parseInt(arr[i]);
		}
		return intArray;
	}

	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[]) {
		int length = arr[0].length();

		for (String s : arr) {
			if(s.length() > length) {
				length = s.length();
			}
		}

		return length;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c) {
		int max = maxLength(arr);
		int index = 0;

		for(String s : arr) {
			s = lpad(s, max, c);
			arr[index] = s;
			index++;
		}
	}
}
