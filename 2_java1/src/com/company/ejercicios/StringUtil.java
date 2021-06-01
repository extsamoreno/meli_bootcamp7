package com.company.ejercicios;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n)
	{
		//Implementación
		String replicated = "";
		for (int i = 0; i < n; i++){
			replicated += c;
		}
		return replicated;
	}
	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	// Que todos los numeros tengan la misma longitud
	public static String lpad(String s,int n,char c)
	{
		//Implementación
		String cadena = "";

		cadena = replicate(c, n - s.length());
		cadena += s;

		return cadena;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		//Implementación
		String[] strChain = new String[arr.length];
		for (int i = 0; i < arr.length; i++){
			strChain[i] = Integer.toString(arr[i]);
		}
		return strChain;
	}
	
	// Retorna un int[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		//Implementación
		int[] strChain = new int[arr.length];
		for (int i = 0; i < arr.length; i++){
			strChain[i] = Integer.parseInt(arr[i]);
		}
		return strChain;

	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		//Implementación
		int max = 0;

		for(int i = 0; i < arr.length; i++){
			if(arr[i].length() > max){
				max = arr[i].length();
			}
		}
		return max;

	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c)
	{
		//Implementación
		for(int i = 0; i < arr.length; i++){
			arr[i] = lpad(arr[i], maxLength(arr), c);
		}

	}
}
