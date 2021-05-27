package ejercicio6;

public class StringUtil {
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n) {
		String cadena = "";

		for (int i = 0; i < n; i++) {
			cadena = cadena + c;
		}

		return cadena;
	}
	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c) {
		String cadena = "";

		for(int i = 0; i < n-1; i++){
			cadena = cadena + c;
		}
		cadena = cadena + s;

		return cadena;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[]) {
		String String[] = new String[arr.length];

		for (int i = 0; i < arr.length; i++) {
			String[i] = Integer.toString(arr[i]);
		}

		return String;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[]) {
		int String[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			String[i] = Integer.parseInt(arr[i]);
		}

		return String;
	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[]) {
		int maxLength = 0;

		for (int i = 0; i < arr.length; i++) {
			if(arr[i].length() > maxLength){
				maxLength = arr[i].length();
			}
		}

		return maxLength;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c) {
		int maxLength = maxLength(arr);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = lpad(arr[i], maxLength, c);
		}
	}
}
