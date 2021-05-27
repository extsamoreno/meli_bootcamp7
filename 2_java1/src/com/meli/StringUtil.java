package com.meli;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n)
	{
		
		//Implementación
		return "Hola";
	}
	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c)
	{
		int cantCharacters = s.length();
		int missingCharacters = n - cantCharacters;
		String newString = Character.toString(c).repeat(missingCharacters) + s;
		return newString;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		String[] newArrString = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			newArrString[i] = String.valueOf(arr[i]);
		}
		return newArrString;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		int[] newArrInt = new int[arr.length];
		for ( int i = 0; i < arr.length; i++ ) {
			newArrInt[i] = Integer.parseInt(arr[i]);
		}
		return newArrInt;
	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		int maxLength = arr[0].length();
		for (String element: arr) {
			if( element.length() > maxLength) {
				maxLength = element.length();
			}
		}
		return maxLength;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c)
	{
		int maxLength = maxLength(arr);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = lpad(arr[i], maxLength, c);
		}
	}
}
