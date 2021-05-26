package com.meli;

import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort
{
	public static void radixSort(int []arr)
	{
		int lonString = arr.length;
		String newString[] = StringUtil.toStringArray(arr);
		StringUtil.lNormalize(newString, '0');

		HashMap<String, ArrayList<String>> listas = new HashMap<>();

		for (int i = 0; i <= 9; i++) {
			listas.put("L" + i, new ArrayList<String>());
		}

		//for (int i = 1; i <= newString[0].length(); i++) {
			for (String string: newString) {
				char number = string.charAt(string.length() - 1);
				ArrayList<String> newArrayList = listas.get("L" + number);
				newArrayList.add(string);
				listas.put("L" + number, newArrayList);
			}
		//}




		for (int i = 0; i <= 9; i++) {
			System.out.println("Lista" + i + " : " + listas.get("L" + i));
		}
	}




	public static void main(String[] args)
	{

		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		radixSort(arr);
		/*
		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":""));
		}
		*/
	}
}

