package PracticoIntegrador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadixSort{

	public static List<String> sort(HashMap<Integer,List<String>> hashContainer, int max, String[] arrStr){
		List<String> list;
		List<String> newList = new ArrayList<>();;

		for(int index = max-1; index >= 0; index--){
			//Init hashContainer of 0 to 9 with empty list
			for(int i=0; i < 10; i++){
				list = new ArrayList<>();
				hashContainer.put(i,list);
			}

			for(String item : arrStr){
				int unit = Character.getNumericValue(item.charAt(index));
				list = hashContainer.get(unit);
				list.add(item);
				hashContainer.put(unit, list);
			}

			newList = new ArrayList<>();

			for(Map.Entry<Integer, List<String>> entry : hashContainer.entrySet()){
				for(String item : entry.getValue()){
					newList.add(item);
				}
			}

			arrStr = newList.toArray(new String[0]);

		}

		return newList;
	}

	public static void radixSort(int []arr){

		String[] arrStr = StringUtil.toStringArray(arr);
		int max = StringUtil.maxLength(arrStr);
		StringUtil.lNormalize(arrStr,'0');

		HashMap<Integer, List<String>> hashContainer = new HashMap<>();

		List<String> newList = sort(hashContainer,max,arrStr);

		arrStr = newList.toArray(new String[0]);

		for(int i = 0; i < arr.length; i++){
			arr[i] = Integer.parseInt(arrStr[i]);
		}

	}

	public static void main(String[] args){
		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		int iArr[] = {3, 673, 106, 45, 2,23 };
		radixSort(arr);

		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":""));
		}
	}
}
