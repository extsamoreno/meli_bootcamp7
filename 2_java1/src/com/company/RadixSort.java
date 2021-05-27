package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort
{
	public static void radixSort(int []arr)
	{
		String[] stringArr = StringUtil.toStringArray(arr);
		StringUtil.lNormalize(stringArr,'0');
		stringArr=order(stringArr);
		arr=StringUtil.toIntArray(stringArr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static String[] order(String []stringArr){
		HashMap hm = hashing();
		for (int i = 0; i < stringArr[i].length(); i++) {
			divideList(stringArr, stringArr[i].length()-1-i, hm);
			stringArr=joinList(stringArr,hm);
		}
		return stringArr;
	}

	public static void divideList(String []stringArr, int index, HashMap hm){
		for (int i = 0; i < stringArr.length; i++) {
			ArrayList<String> myList= (ArrayList<String>) hm.get(Integer.parseInt(stringArr[i].charAt(index)+""));
			myList.add(stringArr[i]);
		}
	}

	public static String[] joinList(String []stringArr,HashMap hm){
		ArrayList<String> tempArr = new ArrayList<>();
		hm.forEach((key, value) -> {
			ArrayList<String> actual = (ArrayList<String>) value;
			for(String numero : actual){
				tempArr.add(numero);
			}
			actual.clear();
		});
		return tempArr.toArray(new String[0]);
	}

	public static HashMap hashing(){
		HashMap<Integer,ArrayList<String>> hm = new HashMap<Integer, ArrayList<String>>();
		for (int i = 0; i < 10; i++) {
			hm.put(i,new ArrayList<String>());
		}
		return hm;
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
