package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RadixSort
{
	public static void radixSort(int []arr)
	{
		String[] stringArray = StringUtil.toStringArray(arr);
		StringUtil.lNormalize(stringArray, '0');

		HashMap<Integer, ArrayList<String>> lists = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			lists.put(i, new ArrayList<>());
		};

		for (int i = stringArray[0].length() - 1; i >= 0; i--) {
			for (String str : stringArray) {
				char last = str.charAt(i);
				int key = Character.getNumericValue(last);
				ArrayList<String> listMap = lists.get(key);
				listMap.add(str);
			}

			int j = 0;

			for(Map.Entry<Integer,ArrayList<String>> entry : lists.entrySet()) {
				for(String s : entry.getValue()) {
					stringArray[j] = s;
					j++;
				}
				entry.getValue().clear();
			}

		}

		int[] intArray = StringUtil.toIntArray(stringArray);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = intArray[i];
		}
	}




	public static void main(String[] args)
	{
		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		radixSort(arr);

		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
		}
	}
}
