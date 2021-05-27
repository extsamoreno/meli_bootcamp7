package com.ejercitacion.mañana;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n)
	{
		String result = "";
		for (int i = 0; i < n; i ++ ) {
			result.concat(String.valueOf(c));
		}
		return result;
	}
	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c)
	{
		int dif = n - s.length();
		if (dif > 0 ) {
			String prefix = "";
			for (int i = 0; i < dif; i++) {
				prefix += String.valueOf(c);
			}
			return prefix + s;
		}
		return s;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		String[] result = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = String.valueOf(arr[i]);
		}
		return result;
	}
	
	// Retorna un int[] conteniendo los elementos de arr
    // representados como enteros
	public static int[] toIntArray(String arr[])
	{
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = Integer.parseInt(arr[i]);
		}
		return result;
	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() > count) {
				count = arr[i].length();
			}
		}
		return count;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c)
	{
	    int maxLenght = maxLength(arr);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = lpad(arr[i], maxLenght, c);
		}
	}

	public static String rpad(String s, char c, int n) {
		int dif = n - s.length();
		if (dif > 0 ) {
			String suffix = "";
			for (int i = 0; i < dif; i++) {
				suffix += String.valueOf(c);
			}
			return s + suffix;
		}
		return s;
	}

	public static String ltrim(String s) {
		return s.stripLeading();
	}

	public static String rtrim(String s) {
		return s.stripTrailing();
	}

	public static String trim(String s) {
		return s.trim();
	}

	public static int indexOfN(String s, char c, int n) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				count++;
				if (count == n) {
					return i;
				}
			}
		}
		if (count == 0) {
			return -1;
		}
		return count;
	}
}
