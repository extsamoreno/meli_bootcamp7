package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RadixSort {
	public static void radixSort(int[] arr) {
		String[] aux = StringUtil.toStringArray(arr);

		StringUtil.lNormalize(aux, '0');

		HashMap<Integer, ArrayList<String>> maps = new HashMap<>();
		for (int i = 0; i < aux.length; i++) {
			maps.put(i, new ArrayList<>());
		}

		for (int j = aux[0].length() - 1; j >= 0; j--) {
			for (String s : aux) {
				int key = Integer.parseInt(String.valueOf(s.charAt(j)));
				maps.get(key).add(s);
			}

			int index = 0;

			for (Map.Entry<Integer, ArrayList<String>> entry : maps.entrySet()) {
				for (String s : entry.getValue()) {
					aux[index] = s;
					index++;
				}
				entry.getValue().clear();
			}
		}

		int[] intArray = StringUtil.toIntArray(aux);
		for (int i = 0; i < intArray.length; i++) {
			arr[i] = intArray[i];
		}
	}

}


