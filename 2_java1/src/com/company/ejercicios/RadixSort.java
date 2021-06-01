package com.company.ejercicios;

import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort
{
	public static void radixSort(int []arr) {

		String sArr[] = StringUtil.toStringArray(arr);
		StringUtil.lNormalize(sArr,'0');
		HashMap<Integer,ArrayList<String>> ed = new HashMap<>();
		int cantDig = sArr[0].length();

		for(int i=0; i<cantDig; i++) {
			inicializarED(ed);
			int digPos = cantDig-1-i;

			for(int j=0; j<sArr.length; j++) {
				int d = sArr[j].charAt(digPos)-'0';
				ed.get(d).add(sArr[j]);
			}

			rearmarArray(sArr,ed);
		}

		int iArr[]=StringUtil.toIntArray(sArr);

		for(int x=0; x<iArr.length;x++) {
			arr[x]=iArr[x];
		}

	}

	private static void rearmarArray(String[] sArr, HashMap<Integer,ArrayList<String>> ed) {

		int k=0;
		for(int i=0; i<10; i++) {

			ArrayList<String> x = ed.get(i);
			for(int j=0; j<x.size(); j++) {

				sArr[k++]=x.get(j);
			}

		}

	}

	private static void inicializarED(HashMap<Integer,ArrayList<String>> ed) {

		ed.clear();
		for(int i=0; i<10; i++) {
			ed.put(i,new ArrayList<>());
		}

	}

	public static void main(String[] args) {

		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		radixSort(arr);

		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":""));
		}
	}

}
