package com.company;

import java.util.ArrayList;
import java.util.HashMap;

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

		ArrayList<String> L0 = new ArrayList<String>();
		ArrayList<String> L1 = new ArrayList<String>();
		ArrayList<String> L2 = new ArrayList<String>();
		ArrayList<String> L3 = new ArrayList<String>();
		ArrayList<String> L4 = new ArrayList<String>();
		ArrayList<String> L5 = new ArrayList<String>();
		ArrayList<String> L6 = new ArrayList<String>();
		ArrayList<String> L7 = new ArrayList<String>();
		ArrayList<String> L8 = new ArrayList<String>();
		ArrayList<String> L9 = new ArrayList<String>();


		for (;largo >= 0;largo--) {

			for (int i = 0; i < arrayStrings.length; i++) {
				char char_aux = aux.get(i).charAt(largo);

				if (char_aux == '0') {
					L0.add(aux.get(i));
				} else if (char_aux == '1') {
					L1.add(aux.get(i));
				} else if (char_aux == '2') {
					L2.add(aux.get(i));
				} else if (char_aux == '3') {
					L3.add(aux.get(i));
				} else if (char_aux == '4') {
					L4.add(aux.get(i));
				} else if (char_aux == '5') {
					L5.add(aux.get(i));
				} else if (char_aux == '6') {
					L6.add(aux.get(i));
				} else if (char_aux == '7') {
					L7.add(aux.get(i));
				} else if (char_aux == '8') {
					L8.add(aux.get(i));
				} else if (char_aux == '9') {
					L9.add(aux.get(i));
				}
			}

			aux.clear();

			aux.addAll(L0);
			aux.addAll(L1);
			aux.addAll(L2);
			aux.addAll(L3);
			aux.addAll(L4);
			aux.addAll(L5);
			aux.addAll(L6);
			aux.addAll(L7);
			aux.addAll(L8);
			aux.addAll(L9);

			L0.clear();
			L1.clear();
			L2.clear();
			L3.clear();
			L4.clear();
			L5.clear();
			L6.clear();
			L7.clear();
			L8.clear();
			L9.clear();

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
