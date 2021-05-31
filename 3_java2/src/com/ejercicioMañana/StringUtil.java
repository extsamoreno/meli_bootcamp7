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

	//	public static String rpad(String s,char c,int n); idem lpad, pero agregando caracteres a la derecha.
	public static String rpad(String s,int n,char c)
	{
		StringBuilder sBuilder = new StringBuilder(s);
		sBuilder.insert(s.length(), replicate(c,n-s.length()));
		s = sBuilder.toString();
		return s;

	}

	//● Retorna una cadena idéntica a s pero sin espacios a la izquierda.
	public static String ltrim(String s){
		int pos = 0;
		while (s.charAt(pos) == ' '){
			pos++;
		}
		StringBuilder sBuilder = new StringBuilder(s);
		sBuilder.replace(0,pos,"");
		return sBuilder.toString();
	}

	//idem ltrim, pero sin espacios a la derecha.
	public static String rtrim(String s){
		int pos = s.length()-1;
		while (s.charAt(pos) == ' '){
			pos--;
		}
		StringBuilder sBuilder = new StringBuilder(s);
		sBuilder.replace(pos +1,s.length(),"");
		return sBuilder.toString();
	}
	//● public static String trim(String s); idem lpad, pero sin espacios a derecha ni izquierda.
	public static String trim(String s){
		return rtrim(ltrim(s));
	}
//		● public static int indexOfN(String s,char c,int n); Retorna la posición de la n-ésima
//	ocurrencia del carácter c dentro de s, o -1 si s no contiene a c. Por ejemplo, si s = “John|Paul|George|Ringo”, c = ‘|’ y n=2, la función debe retornar la posicióon de la
//	segunda ocurrencia del carácter ‘|’ (pipe) dentro de la cadena s. Que, en este caso, es: 9.
	public static int indexOfN(String s,char c,int n){
		var times = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c){
				times++;
				if (times ==n){
					return i;
				}
			}
		}
		return -1;
	}
}
