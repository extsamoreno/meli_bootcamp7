import java.util.Arrays;

public class StringUtil {
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c, int n) {
		//Implementación
		return "";
	}

	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s, int n, char c) {
		//Implementación
		return "";
	}

	// Retorna un String[] conteniendo los elementos de arr
	// representados como cadenas de caracteres
	public static String[] toStringArray(int arr[]) {
		//Implementación
		return null;
	}

	// Retorna un String[] conteniendo los elementos de arr
	// representados como cadenas de caracteres
	public static int[] toIntArray(String arr[]) {
		//Implementación
		return null;
	}


	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[]) {
		//Implementación
		return 0;
	}

	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[], char c) {
		//Implementación

	}

	// Retorna una cadena de longitud n, compuesta por s
	// y procedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String rpad(String cad, char cantCaracteres, int longitudCad) {
		int cant = Character.valueOf(cantCaracteres) - longitudCad;
		for (int i = 0; i < cant; i++)
			cad += 0;
		return cad;
	}

	public static void main(String[] args) {
		//String a = "12";
		//a=rpad(a, (char) 4,a.length());
		//System.out.println(a.toString());

		//String b = "   23";
		//b = ltrim(b);
		//System.out.println(b.toString());


		//String b = "  23  3   ";
		//b = trim(b);
		//System.out.println(b.toString());
		String a = "abasdbasdasdb";
		System.out.println(indexOfN(a, 'a', 4));

	}

	public static int indexOfN(String s, char caracter, int numOcurrencia) {
		int cont = 0;
		char[] arr = s.toCharArray();
		int i = 0;
		for (char c : arr) {
			if (c == caracter) {
				cont++;
				if (cont == numOcurrencia) {
					return i;
				}
			}
			i++;
		}
		return -1;

	}

	public static String ltrim(String s) {
		int i = 0;
		while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		String ltrim = s.substring(i);
		return ltrim;
	}

	public static String rtrim(String s) {

		int i = s.length() - 1;
		while (i >= 0 && Character.isWhitespace(s.charAt(i))) {
			i--;
		}
		String rtrim = s.substring(0, i + 1);
		return rtrim;
	}

	public static String trim(String s) {
		String r = s;
		r = ltrim(r);
		r = rtrim(r);
		return r;
	}

}
