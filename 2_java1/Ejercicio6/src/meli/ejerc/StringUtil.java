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
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		int[] listReturn = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			listReturn[i] = Integer.valueOf(arr[i]);
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
}
