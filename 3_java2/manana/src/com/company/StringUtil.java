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

	public static String rpad(String s,char c,int n) {
		int cant_agregar = n - s.length();
		String pad = replicate(c,cant_agregar);

		return s + pad;
	}

	// Retorna una cadena idéntica a s pero sin espacios a la izquierda.
	public static String ltrim(String s) {
		int i = 0;
		while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		return i>=0?s.substring(i):"";
	}

	// idem ltrim, pero sin espacios a la derecha.
	public static String rtrim(String s) {
		int i = s.length() - 1;
		while (i >= 0 && Character.isWhitespace(s.charAt(i))) {
			i--;
		}
		return i>=0?s.substring(0,i+1):"";
	}

	// idem lpad, pero sin espacios a derecha ni izquierda.
	public static String trim(String s) {
		return ltrim(rtrim(s));
	}

	//Retorna la posición de la n-ésima
	//ocurrencia del carácter c dentro de s, o -1 si s no contiene a c.
	//Por ejemplo, si s = “John|Paul|George|Ringo”, c = ‘|’ y n=2, la función debe retornar la posicióon de la
	//segunda ocurrencia del carácter ‘|’ (pipe) dentro de la cadena s. Que, en este caso, es: 9.
	public static int indexOfN(String s,char c,int n) {
		for (int i= 0;i < s.length(); i++) {
			if (s.charAt(i) == c) {
				if (--n == 0) {
					return i;
				}
			}
		}
		return -1;
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
}
