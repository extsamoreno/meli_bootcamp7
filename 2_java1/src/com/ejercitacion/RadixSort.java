package com.ejercitacion;

import java.util.ArrayList;
import java.util.List;

import static com.ejercitacion.StringUtil.*;

public class RadixSort
{
	public static void radixSort(int []arr)
	{
		String[] strArr = toStringArray(arr);
		lNormalize(strArr, '0');
		int index = strArr[0].length() - 1;
		for (int i = index; i >= 0; i--) {
			sort(strArr, i);
		}
		int[] arrAux = toIntArray(strArr);
		for (int i = 0; i < arrAux.length; i++) {
			arr[i] = arrAux[i];
		}

	}

	public static void sort(String[] strArr, int index) {
		List<String> list0 = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		List<String> list3 = new ArrayList<>();
		List<String> list4 = new ArrayList<>();
		List<String> list5 = new ArrayList<>();
		List<String> list6 = new ArrayList<>();
		List<String> list7 = new ArrayList<>();
		List<String> list8 = new ArrayList<>();
		List<String> list9 = new ArrayList<>();
		for (int i = 0; i < strArr.length; i++) {
			switch (strArr[i].charAt(index)) {
				case '0':
					list0.add(strArr[i]);
					break;
				case '1':
					list1.add(strArr[i]);
					break;
				case '2':
					list2.add(strArr[i]);
					break;
				case '3':
					list3.add(strArr[i]);
					break;
				case '4':
					list4.add(strArr[i]);
					break;
				case '5':
					list5.add(strArr[i]);
					break;
				case '6':
					list6.add(strArr[i]);
					break;
				case '7':
					list7.add(strArr[i]);
					break;
				case '8':
					list8.add(strArr[i]);
					break;
				case '9':
					list9.add(strArr[i]);
					break;
			}
		}
		list0.addAll(list1);
		list0.addAll(list2);
		list0.addAll(list3);
		list0.addAll(list4);
		list0.addAll(list5);
		list0.addAll(list6);
		list0.addAll(list7);
		list0.addAll(list8);
		list0.addAll(list9);

		Object[] objArr = list0.toArray();

		int i = 0;
		for (Object obj : objArr) {
			strArr[i++] = (String) obj;
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
