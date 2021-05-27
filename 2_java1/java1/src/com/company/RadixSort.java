package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import

public class RadixSort
{
	public static void radixSort(int []arr)
	{
		//PASO 1
		String arrayStrings[] = StringUtil.toStringArray(arr);


		//PASO2
		StringUtil.lNormalize(arrayStrings, '0');
		int largo = StringUtil.maxLength(arrayStrings) - 1;

		ArrayList<String> aux = new ArrayList<String>();
		for (int i = 0; i < arrayStrings.length; i++) {
			aux.add(arrayStrings[i]);
		}

		//PASO3
		HashMap<Integer, ArrayList<String>> hashMapDigitos = GetHashMapForRadix();

		for (;largo >= 0;largo--) {

			for (int i = 0; i < arrayStrings.length; i++) {
				int char_aux = Integer.parseInt(String.valueOf(aux.get(i).charAt(largo)));
				hashMapDigitos.get(char_aux).add(aux.get(i));
			}

			aux.clear();

			for (Map.Entry<Integer, ArrayList<String>> entry : hashMapDigitos.entrySet())  {
				aux.addAll(entry.getValue());
				entry.getValue().clear();
			}
		}

		for (int i = 0; i < arrayStrings.length; i++) {
			arrayStrings[i] = aux.get(i);
		}

		int resultado[] = StringUtil.toIntArray(arrayStrings);

		for(int i=0; i<arr.length;i++)
		{
			arr[i] = resultado[i];
		}

	}

	public static HashMap<Integer, ArrayList<String>> GetHashMapForRadix() {
		HashMap<Integer, ArrayList<String>> hashMapDigitos = new HashMap<>();
		hashMapDigitos.put(0, new ArrayList<String>());
		hashMapDigitos.put(1, new ArrayList<String>());
		hashMapDigitos.put(2, new ArrayList<String>());
		hashMapDigitos.put(3, new ArrayList<String>());
		hashMapDigitos.put(4, new ArrayList<String>());
		hashMapDigitos.put(5, new ArrayList<String>());
		hashMapDigitos.put(6, new ArrayList<String>());
		hashMapDigitos.put(7, new ArrayList<String>());
		hashMapDigitos.put(8, new ArrayList<String>());
		hashMapDigitos.put(9, new ArrayList<String>());

		return hashMapDigitos;
	}

	//Mejoras
	//Ver de si cuando agrega al hash map, existe, ir agregando al hashmap dinamicamente, no tener que instanciarlo asi
	//forzado
	public static void main(String[] args)
	{
		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		radixSort(arr);
		
		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":"\n"));
		}
	}
}
