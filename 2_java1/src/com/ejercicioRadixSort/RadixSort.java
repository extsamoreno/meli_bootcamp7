package com.ejercicioRadixSort;

import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort
{
	public static void radixSort(int[] arr)
	{
		var strArr = StringUtil.toStringArray(arr);
		StringUtil.lNormalize(strArr,'0');

		var listDict = new HashMap<Integer,ArrayList>();
		for (int i = 0; i < 10; i++) {
			listDict.put(i,new ArrayList<String>());
		}

		for (int i = 0; i < strArr[0].length(); i++) {
			fillLists(strArr, listDict,i);
			regenerateArray(strArr, listDict);
		}

		var intArr = StringUtil.toIntArray(strArr);
		for (int i = 0; i < intArr.length; i++) {
			arr[i] = intArr[i];
		}
	}

	private static void regenerateArray(String[] strArr, HashMap<Integer, ArrayList> listDict) {
		ArrayList<String> list;
		int position = 0;
		for (int i = 0; i < 10; i++) {
			list = listDict.get(i);
			for (int j = 0; j <list.size() ; j++) {
				strArr[position] = list.get(j);
				position++;
			}
		}
	}

	public static void fillLists(String[] strArr, HashMap<Integer,ArrayList> listDict, int position){
		for (int i = 0; i < 10; i++) {
			listDict.get(i).clear();
		}
		var lastPositon = strArr[0].length() - 1;
		for (String str: strArr) {
			listDict.get(str.charAt(lastPositon-position)-'0').add(str);
		}
	}


	public static void main(String[] args)
	{
//		var a = StringUtil.toStringArray(new int[]{1,2,3,5});
//		var aa = StringUtil.toIntArray(new String[]{"1","2","3","5"});
//
//
//		var b = StringUtil.replicate('r',10);
//
//		var c = StringUtil.lpad("11",7,'0');
//
//		var d = StringUtil.maxLength(new String[]{"2","as","2","as4589","2","as","asdq","2","as"});
//
//		var e = new String[]{"2","as","2","as4589","2","as","asdq","2","as"};
//
//		StringUtil.lNormalize(e,'0');

		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		radixSort(arr);

		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":""));
		}
	}
}
