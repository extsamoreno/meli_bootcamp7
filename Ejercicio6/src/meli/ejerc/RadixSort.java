package meli.ejerc;

import java.util.*;

public class RadixSort
{
	public static void radixSort(int []arr)
	{
		Map<Character, ArrayList<String>> map = new HashMap<>();
		StringUtil utils = new StringUtil();
		String[] strArray = utils.toStringArray(arr);
		int longest = utils.maxLength(arr);
		List<String> normalizedArray = utils.lNormalize(strArray,longest);

		for(int i = 1; i <= longest; i++){
			map = utils.fillMap(map, normalizedArray, i);
			normalizedArray.clear();
			for (ArrayList<String> value : map.values()){
				for (String number : value) {
					normalizedArray.add(number);
				}
			}
		}

		for(String number : normalizedArray)
		{
			String divisor = number.equals(normalizedArray.get(normalizedArray.size() -1)) ? "" : "; ";
			System.out.print(number + divisor);
		}
	}

	public static void main(String[] args)
	{
		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		radixSort(arr);
	}
}