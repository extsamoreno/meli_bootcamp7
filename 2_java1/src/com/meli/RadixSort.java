package com.meli;

import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort
{
	public static void radixSort(int []arr)
	{
		String newString[] = StringUtil.toStringArray(arr);
		StringUtil.lNormalize(newString, '0');
		HashMap<Integer, ArrayList<String>> listas = new HashMap<>();
		for (int i = 0; i < newString[0].length(); i++) {
			int indexDig = newString[0].length() - 1 - i;
			for (int j = 0; j <= 9; j++) {
				listas.put(j, new ArrayList<String>());
			}
			for (int k = 0; k < newString.length; k++) {
				int digito = newString[k].charAt(indexDig) - '0';
				listas.get(digito).add(newString[k]);
			}
			int index = 0;
			for (int m = 0; m <= 9; m++) {
				ArrayList<String> lista = listas.get(m);
				for (int x = 0; x < lista.size(); x++) {
					newString[index++] = lista.get(x);
				}
			}
		}

		int newListNum[] = StringUtil.toIntArray(newString);
		for (int y = 0; y < newListNum.length; y++) {
			arr[y] = newListNum[y];
		}
	}

	public static void main(String[] args)
	{
		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		radixSort(arr);
		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":""));
		}
	}
}

