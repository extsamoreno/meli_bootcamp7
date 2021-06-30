package radixSort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RadixSort {


	public static void radixSort(int[] arr)	{

		String[] sArr = StringUtil.toStringArray(arr);
		StringUtil.lNormalize(sArr, '0');



		for (int j = 1; j < sArr[0].length(); j++) {
			HashMap<Character, ArrayList<String>> mapList = new HashMap<>();
			List<String> sList = new ArrayList<>();
			for (int i = 0; i < sArr.length; i++) {
				char key = sArr[i].charAt(sArr[i].length()-j);
				if (mapList.get(key) == null){
					mapList.put(key, new ArrayList<>());
				}
				mapList.get(key).add(sArr[i]);
			}
			sList.clear();
			for (HashMap.Entry<Character, ArrayList<String>> entry : mapList.entrySet()) {
				sList.addAll(entry.getValue());
			}
		}
	//	StringUtil.toIntArray(Arrays.)
	}

	public static void main(String[] args) {
		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		radixSort(arr);
		
		for(int i=0; i<arr.length;i++) {
			System.out.println(arr[i]+(i<arr.length-1?",":""));
		}
	}
}
