package com.company;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n)
	{
		String num="";
		for (int i = 0; i < n; i++) {
			num=num+c;
		}
		return num;
	}
	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c)
	{
		return replicate(c,n)+s;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		String[] newArr = new String[arr.length];
		for(int i=0 ; i<arr.length ; i++){
			newArr[i]=String.valueOf(arr[i]);
		}
		return newArr;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		int[] newArr = new int[arr.length];
		for(int i=0 ; i<arr.length ; i++){
			newArr[i]=Integer.parseInt(arr[i]);
		}
		return newArr;
	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		int max=0;
		for(int i=0 ; i<arr.length ; i++){
			if(arr[i].length()>max){
				max=arr[i].length();
			}
		}
		return max;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c)
	{
		int max = maxLength(arr);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].length()<max){
				arr[i]=lpad(arr[i],max-arr[i].length(), c);
			}
		}
	}
}
