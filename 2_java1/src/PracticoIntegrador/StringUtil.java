package PracticoIntegrador;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n){
		String result = "";

		for(int i = 0; i <n ; i++){
			result = c + result;
		}

		return result;
	}
	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c){
		if(s.length() < n){
			int quantityToAdd = n - s.length();
			s = replicate(c,quantityToAdd) + s;
		}

		return s;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[]){
		return Arrays.stream(arr)
				.mapToObj(String::valueOf)
				.toArray(String[]::new);
	}
	
	// Retorna un int[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[]){
		return Arrays.stream(arr)
				.mapToInt(Integer::parseInt)
				.toArray();
	}

	// Retorna la longitud del elemento con mayor cantidad
	// de caracteres del array arr
	public static int maxLength(String arr[]){
		int max = 0;

		for(String item : arr){
			if(item.length() > max){
				max = item.length();
			}
		}

		return max;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c){
		int max = maxLength(arr);
		String[] arrAux = arr;

		for(int i = 0; i < arr.length; i++){
			arr[i] = lpad(arr[i], max, c);
		}

	}
}
