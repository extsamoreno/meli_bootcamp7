package utils;

import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort
{
	private static void radixSort(int[] arr)	{
		char char1='0';
		String[] array= StringUtil.toStringArray(arr);

		StringUtil.lNormalize(array,char1);
		int max=array[0].length();
		for (int i = 0; i < (array.length) ; i++) {
			array = oderByIndex(array,i,max);
		}
		int[] result=StringUtil.toIntArray(array);
		for (int i = 0; i < arr.length; i++) {
			arr[i]= result[i];
		}
	}



	private static String[] oderByIndex(String[] original,int lPosition,int max){
		if(lPosition>=max){
			return original;
		}
		HashMap<String, ArrayList<String>> hashResult = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < original.length; i++) {
			String key= original[i].substring(max-lPosition-1,max-lPosition);
			ArrayList<String> array=hashResult.get(key);
			if(array!=null){
				array.add(original[i]);
			}else {
				ArrayList newArray=new ArrayList<>();
				newArray.add(original[i]);
				hashResult.put(key,newArray);
			}
		}
		return getListByHash(hashResult,original.length);
	}

	private static String[] getListByHash(HashMap<String, ArrayList<String>> hashMap,int size){
		String[] arrayOrdered=new String[size];
		int pos=0;
		for (int i = 0; i < 10; i++) {
			ArrayList<String> array=hashMap.get(String.valueOf(i));
			if(array!=null){
				for (String s:array) {
					arrayOrdered[pos]=s;
					pos++;
				}
			}
		}
		return arrayOrdered;
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
