package utils;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n){
		return String.valueOf(c).repeat(n);
	}
	
	// Retorna una cadena de longitud n, compuesta por strings
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c){
		return replicate(c,n-s.length())+s;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		String[] array = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			array[i]=String.valueOf(arr[i]);
		}
		return array;
	}

	//Retorna una cadena idéntica a s
	// pero sin espacios a la izquierda.
	public static String ltrim(String s){
		int i = 0;
		while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		String ltrim = s.substring(i);
		return ltrim;
	}

	//Retorna una cadena idéntica a s
	// pero sin espacios a la derecha.
	public static String rtrim(String s){
		int i = s.length()-1;
		while (i >= 0 && Character.isWhitespace(s.charAt(i))) {
			i--;
		}
		String rtrim = s.substring(0,i);
		return rtrim;
	}

	//Retorna una cadena idéntica a s
	// pero sin espacios a la derecha ni a la izquierda.
	public static String trim(String s){
		s=ltrim(s);
		s=rtrim(s);
		return s;
	}

	public static int indexOfN(String s,char c,int n){
		int result = -1;
		for (int i = 0; i < n; i++) {
			int index=s.indexOf(c);
			result +=index+1;
			if(index != -1){
				s=s.substring(index+1);
			}else{
				return -1;
			}

		}
		return result;
	}

	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		int[] array = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			array[i]=Integer.valueOf(arr[i]);
		}
		return array;
	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[]){
		int maxL= 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].length()>maxL){
				maxL=arr[i].length();
			}
		}
		return maxL;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c)
	{
		int maximo= maxLength(arr);
		for (int i = 0; i < arr.length; i++) {
			arr[i]= lpad(arr[i],maximo,c);
		}
	}
}
