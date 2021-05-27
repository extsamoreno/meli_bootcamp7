package utils;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n){
		return String.valueOf(c).repeat(n);
	}
	
	// Retorna una cadena de longitud n, compuesta por strings
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c){
		return replicate(c,n-s.length())+s;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		String[] array = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			array[i]=String.valueOf(arr[i]);
		}
		return array;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		int[] array = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			array[i]=Integer.valueOf(arr[i]);
		}
		return array;
	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[]){
		int maxL= 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].length()>maxL){
				maxL=arr[i].length();
			}
		}
		return maxL;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c)
	{
		int maximo= maxLength(arr);
		for (int i = 0; i < arr.length; i++) {
			arr[i]= lpad(arr[i],maximo,c);
		}
	}
}
