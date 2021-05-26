package meli.ejerc;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n)
	{
		String result = "";
		for (int i = 1; i <= n; i++)
			result += c;

		return result;
	}
	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String load(String s,int n,char c)
	{
		String result = "";

		int lengthS = s.length();
		if(n == lengthS || lengthS > n)
			return s;

		int left = n-lengthS;

		result = replicate(c, left);

		return result + s;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		String[] result = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = Integer.toString(arr[i]);
		}

		return result;
	}
	
	// Retorna un in[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
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
		int aux = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].length() > aux)
				aux =  arr[i].length();
		}
		return aux;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c)
	{
		int maxLen = maxLength(arr);

		for (int i = 0; i < arr.length; i++)
			if(arr[i].length() < maxLen){
				arr[i]=load(arr[i], maxLen, c);
		}
	}
}
