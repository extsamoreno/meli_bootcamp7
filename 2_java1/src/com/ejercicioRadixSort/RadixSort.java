package com.ejercicioRadixSort;

import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort
{
	public static void radixSort(int []arr)
	{
		//Implementación
	}




	public static void main(String[] args)
	{
		var a = StringUtil.toStringArray(new int[]{1,2,3,5});
		var aa = StringUtil.toIntArray(new String[]{"1","2","3","5"});


		var b = StringUtil.replicate('r',10);

		var c = StringUtil.lpad("11",7,'0');

		var d = StringUtil.maxLength(new String[]{"2","as","2","as4589","2","as","asdq","2","as"});

		var e = new String[]{"2","as","2","as4589","2","as","asdq","2","as"};

		StringUtil.lNormalize(e,'0');

		System.out.println("lala");
//		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
//		radixSort(arr);
//
//		for(int i=0; i<arr.length;i++)
//		{
//			System.out.print(arr[i]+(i<arr.length-1?",":""));
//		}
	}
}
