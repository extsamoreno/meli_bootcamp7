package com.company;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n)
	{
		String resultado = "";
		for (; n > 0; n--) {
			resultado += c;
		}
		return resultado;
	}

	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c)
	{
		int cant_agregar = n - s.length();
		String pad = replicate(c,cant_agregar);

		return pad + s;
	}

	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		String arrayString[] = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arrayString[i] = Integer.toString(arr[i]);
		}
		return arrayString;
	}

	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		int arrayInt[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arrayInt[i] = Integer.parseInt(arr[i]);
		}
		return arrayInt;
	}


	// Retorna la longitud del elemento con mayor cantidad
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		int largo_max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (largo_max<arr[i].length()) largo_max =arr[i].length();
		}

		return largo_max;
	}

	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c)
	{
		int largo = maxLength(arr);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = lpad(arr[i],largo,'0');
		}
	}


	// Retorna una cadena de longitud n, compuesta por s
	// y le concatena al final tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String rpad(String s,int n,char c)
	{
		int cant_agregar = n - s.length();
		String pad = replicate(c,cant_agregar);

		return s + pad;
	}

	public static String rTrim(String s) {
		int stringLength = s.length();

		return "";
	}

}
