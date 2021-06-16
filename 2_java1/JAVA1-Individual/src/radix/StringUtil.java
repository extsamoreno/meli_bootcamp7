package radix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StringUtil {

	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n) {

		StringBuilder s = new StringBuilder();
		for (int j = 0 ; j < n; j++) {
			s.insert(0, c);
		}
		return s.toString();

	}
	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c) {

		int toAdd;

		if(s.length() < n) {
			toAdd = n - s.length();
			s = replicate(c, toAdd) + s;
		}
		return s;

	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int[] arr) {

		String[] strings = new String[arr.length];

		for(int i = 0 ; i < arr.length ; i++) {
			strings[i] = Integer.toString(arr[i]);
		}

		return strings;

	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String[] arr) {

		int[] intArray = new int[arr.length];

		for(int i = 0 ; i < arr.length ; i++) {
			intArray[i] = Integer.parseInt(arr[i]);
		}

		return intArray;

	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String[] arr) {

		int length = -1;

		for (String s : arr) {
			if(length < s.length()) {
				length = s.length();
			}
		}

		return length;

	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String[] arr,char c) {

		int length = maxLength(arr);

		for (int i = 0 ; i < arr.length ; i++) {
			arr[i] = lpad(arr[i], length, c);
		}

	}

	public static void makeTenList(HashMap<Integer, ArrayList<String>> map) {

		for (int i = 0 ; i < 10 ; i++) {
			map.put(i, new ArrayList<>());
		}

	}

	public static void convertToList(String [] arr, HashMap<Integer, ArrayList<String>> map, int index) {

		for (String s : arr) {
			switch (s.charAt(index)) {
				case '0':
					map.get(0).add(s);
					break;
				case '1':
					map.get(1).add(s);
					break;
				case '2':
					map.get(2).add(s);
					break;
				case '3':
					map.get(3).add(s);
					break;
				case '4':
					map.get(4).add(s);
					break;
				case '5':
					map.get(5).add(s);
					break;
				case '6':
					map.get(6).add(s);
					break;
				case '7':
					map.get(7).add(s);
					break;
				case '8':
					map.get(8).add(s);
					break;
				case '9':
					map.get(9).add(s);
					break;
				default:
					System.out.println("ERROR!");
					break;
			}
		}

	}

	public static void chargeNewData(String [] arr, HashMap<Integer, ArrayList<String>> map) {

		int z = 0;
		for(Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
			ArrayList<String> l = entry.getValue();
			for (String s : l) {
				arr[z] = s;
				z++;
			}
		}

	}

	public static void clearAllLists(HashMap<Integer, ArrayList<String>> map) {

		for(Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
			entry.getValue().clear();
		}

	}
}
