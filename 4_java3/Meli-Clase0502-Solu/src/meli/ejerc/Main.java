package meli.ejerc;

import java.util.Comparator;

public class Main
{
	public static void main(String[] args)
	{	
		Integer arr[] = createIntArray(100000);

		Sorter<Integer> sorter = (Sorter)MiFactory.getInstance("sorter");
		
		Comparator<Integer> c = (a,b)->a-b;
		
		Timer t = new Timer();
		t.start();
		sorter.ordenar(arr,c);
		t.stop();
		System.out.println(t.elapsedTime());
//		printArray(arr);
	}
	
	private  static <T> void printArray(T arr[])
	{
		for(T t:arr)
		{
			System.out.println(t);
		}
	}

	private static Integer[] createIntArray(int n)
	{
		Integer arr[] = new Integer[n];
		for(int i=n-1;i>=0; i--)
		{
			arr[n-i-1]=i;
		}
		return arr;
	}
}
