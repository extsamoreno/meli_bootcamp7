package radixSort;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n) {
		String cadena = "";
		for (int i = 0; i < n; i++) {
			cadena += c;
		}
		return cadena;
	}
	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c) {
		String cadena = "";
		for (int i = 0; i<(n-s.length()); i++){
			cadena += c;
		}
		return (cadena+s);
	}

	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String rpad(String s,char c,int n){
		String cadena = "";
		for (int i = 0; i<(n-s.length()); i++){
			cadena += c;
		}
		return (s+cadena);
	}

	//Retorna una cadena idéntica a s pero sin espacios a la izquierda
	public static String ltrim(String s) {
		return s.replaceAll("^\\s+", "");
	}

	//Retorna una cadena idéntica a s pero sin espacios a la derecha
	public static String rtrim(String s) {
		return s.replaceAll("^\\s+$", "");
	}

	//Retorna una cadena idéntica a s pero sin espacios a derecha ni izquierda.
	public static String trim(String s){
		return s.trim();
	}

	//Retorna la posición de la n-ésima
	//ocurrencia del carácter c dentro de s, o -1 si s no contiene a c.
	public static int indexOfN(String s,char c,int n) {
		int appearences = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				appearences++;
				if (appearences == n) {
					return i;
				}
			}
		}
		return -1;
	}

	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[]) {
		String[] arrayStrings = new String[arr.length];

		for (int i = 0; i < arr.length; i++) {
			arrayStrings[i] = Integer.toString(arr[i]);
		}

		return arrayStrings;
	}
	
	// Retorna un int[] conteniendo los elementos de arr
    // representados como numeros enteros
	public static int[] toIntArray(String arr[]) {
		int[] arrayInt = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			arrayInt[i] = Integer.valueOf(arr[i]);
		}

		return arrayInt;
	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[]) {
		int maxLength = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() > maxLength)
				maxLength = arr[i].length();
		}
		return maxLength;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = lpad(arr[i], maxLength(arr), c);
		}
	}
}
