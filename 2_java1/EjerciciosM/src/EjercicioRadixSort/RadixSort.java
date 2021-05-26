package EjercicioRadixSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RadixSort
{
	public static void radixSort(int []arr)
	{
		HashMap<Integer, ArrayList<String>> listas = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			listas.put(i, new ArrayList<>());
		}

		String[] arrString = StringUtil.toStringArray(arr);
		StringUtil.lNormalize(arrString, '0');

		for (int i = 0; i < StringUtil.maxLength(arrString); i++) {
			for( var number : arrString ){
				var caracterNumerico = Character.getNumericValue(number.charAt(number.length()-1-i));
				var lista = listas.get(caracterNumerico);
				lista.add(number);
			}
			ArrayList<String> ordenadoIntermedio = new ArrayList<>();
			for (Map.Entry<Integer, ArrayList<String>> entry : listas.entrySet()){
				ordenadoIntermedio.addAll(entry.getValue());
				entry.getValue().clear();
			}
			arrString = ordenadoIntermedio.toArray(new String[0]);
		}

		var arrNumber = StringUtil.toIntArray(arrString);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arrNumber[i];
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
