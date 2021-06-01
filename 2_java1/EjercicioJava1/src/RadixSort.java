import java.util.ArrayList;
import java.util.HashMap;

public class RadixSort
{


	public static void radixSort(int []arr)
	{
		String[] arrEnString = StringUtil.toStringArray(arr);
		StringUtil.lNormalize(arrEnString,'0');

		int mayorTamano = StringUtil.maxLength(arrEnString);
		for (int i = 0; i < mayorTamano; i++) {

			for (String elemento : arrEnString) {
				StringUtil.agregarEnArregloAdecuado(elemento,i);
			}
			arrEnString = StringUtil.armarLista(arr.length);
		}

		int[] preResultado = StringUtil.toIntArray(arrEnString);

		for (int i = 0; i < preResultado.length; i++) {
			arr[i] = preResultado[i];
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
