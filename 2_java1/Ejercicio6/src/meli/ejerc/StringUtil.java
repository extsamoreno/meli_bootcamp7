package meli.ejerc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringUtil
{
	public static Map fillMap(Map map, List<String> list, int position){
		Map<Character, List<String>> items = new HashMap<>();
		for(String number : list){
			items.computeIfAbsent((number.charAt(number.length() - position)), k -> new ArrayList<>()).add(number);
		}
		return items;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		String[] listReturn = new String[arr.length];
		for(int i=0;i<arr.length;i++){
			listReturn[i] = String.valueOf(arr[i]);
		}
		return listReturn;
	}
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(int[] arr)
	{
		int longest = 0;
		for(int number : arr){
			if(String.valueOf(number).length()>longest){
				longest = String.valueOf(number).length();
			}
		}
		return longest;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static List<String> lNormalize(String arr[], int longest)
	{
		List<String> resultWithZeros = new ArrayList<String>();
		for(String number : arr){
			int zeroToAdd = longest - number.length();
			while(zeroToAdd>0) {
				number = "0" + number;
				zeroToAdd--;
			}
			resultWithZeros.add(number);
		}
		return resultWithZeros;
	}

	public static String rpad(String s,char c,int n){
		int charToAdd = n - s.length();
		while (charToAdd > 0) {
			s = s + c;
			charToAdd--;
		}
		return s;
	}

	public static String lpad(String s,char c,int n) {
		int charToAdd = n - s.length();
		while (charToAdd > 0) {
			s = c + s;
			charToAdd--;
		}
		return s;
	}

	public static String ltrim(String s) {
//		int position = 0;
//		while (position < s.length() && Character.isWhitespace(s.charAt(position))) {
//			position++;
//		}
//		String ltrim = s.substring(position);
		String ltrim = s.replaceAll("^\\s+", "");
		return ltrim;
	}

	public static String rtrim(String s) {
//		int position = s.length()-1;
//		while (position >= 0 && Character.isWhitespace(s.charAt(position))) {
//			position++;
//		}
//		String rtrim = s.substring(0,position+1);
		String rtrim = s.replaceAll("\\s+$", "");
		return rtrim;
	}

	public static String trim(String s) {
		String trim = ltrim(s);
		trim = rtrim(trim);
		return trim;
	}

	public static int indexOfN(String s,char c,int n) {
		int cont = 0;
		int i = 0;
		while (i < s.length()){
			if (s.charAt(i) == c) {
				cont++;
			}
			if (n == cont) return i;
			i++;
		}
		return -1;
	}
}
