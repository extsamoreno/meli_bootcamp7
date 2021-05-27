package meli.ejerc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class RadixSort
{
	static HashMap<Integer, ArrayList<String>> mapLists = new HashMap<Integer, ArrayList<String>>();

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
			int lengthElement = arrString[i].length();
		}

		//paso3
		loadMap();

		int maxLength = meli.ejerc.StringUtil.maxLength(arrString);

		//paso 4 y paso5
		for (int i = maxLength-1 ; i >= 0 ; i--) {

			for (int j = 0; j < arrString.length; j++) {

				String value = arrString[j];
				char charCurrent = value.charAt(i);

				ArrayList<String> temp = mapLists.get(Integer.parseInt(Character.toString(charCurrent)));
				temp.add(arrString[j]);
				arrString[j] = "";
			}

			mapToArray(arrString);

		}

		//vuelvo a trasformar rellenar el int[]
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(arrString[i]);



	}

	public static void loadMap(){
		for (int i = 0; i <= 9; i++) {
			mapLists.put(i, new ArrayList<String>());
		}
	}





	public static void mapToArray(String[] arr){
		//contador para ir agregando elementos al array :(
		int count=0;


		for (Map.Entry<Integer, ArrayList<String>> entry : mapLists.entrySet() ) {

			ArrayList<String> arrCurrent = entry.getValue();

			for (int i = 0; i < arrCurrent.stream().count(); i++) {
				arr[count] = arrCurrent.get(i);
				count++;
			}
			arrCurrent.clear();
		}
	}














}
