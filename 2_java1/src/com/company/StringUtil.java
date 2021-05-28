package com.company;

public class StringUtil {/*
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
		String myString = "";
		while(s.length() < n){
				myString = c+myString;
		}
		return myString;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		String myString[] = new String[arr.length];
		for(int i =0; i< arr.length; i++){
			myString[i] = arr[i].toStringArray();
		}
		return myString;

	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		int myInt[] = new int[arr.length];
		for(int i =0; i< arr.length; i++){
			myInt[i] = Integer.parceInt(arr[i]);
		}
		return myInt;
	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		int maxLength = 0;

		for(int i =0; i< arr.length; i++){
			if(arr[1].length > maxLength){
				maxLength = arr[1].length;
			}
		}
		return maxLength;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c)
	{
		int maxLength = maxLength(arr);

		for(int i =0; i< arr.length; i++){
			lpad(arr[i],maxLength,c);
		}
	}*/
}
