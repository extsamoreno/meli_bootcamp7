package meli.ejerc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class RadixSort
{
	static Hashtable<Integer, ArrayList<String>> mapLists = new Hashtable<Integer, ArrayList<String>>();

	public static void main(String[] args)
	{
		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		radixSort(arr);

		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":""));
		}
	}

	public static void radixSort(int []arr)
	{
		//paso1
		String[] arrString = meli.ejerc.StringUtil.toStringArray(arr);

		//paso2
		meli.ejerc.StringUtil.lNormalize(arrString, '0');

		for (int i = 0; i < arrString.length; i++) {
			int lengthElemrnt = arrString[i].length();
		}

		//paso3


	}

	public static void loadMap(){
		for (int i = 0; i <= 9; i++) {
			mapLists.put(0, new ArrayList<String>());
		}
	}














}
