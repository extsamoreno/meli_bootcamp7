public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n)
	{
		String result = "";
		for(int i = 0; i < n; i++){
			result = result + c;
		}

		return result;
	}

	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c)
	{
		int longitude = s.length();

		String prefix = replicate(c, n - longitude);
		return prefix + s;

	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		//Implementación
		String[] result = new String[arr.length];

		for (int i = 0; i < arr.length; i++){
			result[i] = Integer.toString(arr[i]);
		}

		return result;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		int result[] = new int[arr.length];

		for(int i = 0; i < arr.length; i++){
			result[i] = Integer.parseInt(arr[i]);
		}
		return result;
	}


	// Retorna la longitud del elemento con mayor cantidad
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		int max = arr[0].length();
		for(int i = 1; i < arr.length; i++){
			if (arr[i].length() > max){
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
		int maxLength = maxLength(arr);

		for(int i=0; i < arr.length; i++){
			arr[i]= lpad(arr[i], maxLength, c);
		}

	}
}
