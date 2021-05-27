package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

		for (int i = 0; i < stringArray.length; i++) {
			char last = stringArray[i].charAt(stringArray[i].length() - 1);
			int key = Character.getNumericValue(last);
			ArrayList<String> listMap = lists.get(key);
			listMap.add(stringArray[i]);
		}

		for (int i = 0; i < 10; i++) {
			for (String num: lists.get(i)) {
				stringArray[i] = num;
			}
		}
		for (String c:
			 stringArray) {
			System.out.println(c);
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
