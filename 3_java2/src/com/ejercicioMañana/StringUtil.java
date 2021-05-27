package com.ejercicioMañana;

public class StringUtil
{


	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n)
	{
		StringBuilder s = new StringBuilder();
		for (int i = 0; i <n ; i++) {
			s.append(c);
		}
		return s.toString();
	}
	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c)
	{
		StringBuilder sBuilder = new StringBuilder(s);
		sBuilder.insert(0, replicate(c,n-s.length()));
		s = sBuilder.toString();
		return s;

	}

	// Retorna un String[] conteniendo los elementos de arr
	// representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		String[] stringArray = new String[arr.length];
		for (int i = 0; i <arr.length ; i++) {
			stringArray[i] = Integer.toString(arr[i]);
		}
		return stringArray;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		var intArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intArr[i] = Integer.parseInt(arr[i]);
		}
		return intArr;

	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length()>max){
				max = arr[i].length();
			};
		}
		return max;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c)
	{
		for (int i = 0; i < arr.length; i++) {
			arr[i] = lpad(arr[i],maxLength(arr),c);
		}

	}
}
