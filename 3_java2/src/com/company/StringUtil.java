package com.company;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n)
	{
		String num="";
		for (int i = 0; i < n; i++) {
			num=num+c;
		}
		return num;
	}
	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c)
	{
		return replicate(c,n)+s;
	}

	public static String rpad(String s,int n,char c)
	{
		return s+replicate(c,n);
	}

	public static String lTrim(String s)
	{
		while(s.charAt(0)==' '){
			s=s.substring(1);
		}
		return s;
	}

	public static String rTrim(String s)
	{
		while(s.charAt(s.length()-1)==' '){
			s=s.substring(0,s.length()-2);
		}
		return s;
	}

	public static String trim(String s){
		s=lTrim(s);
		s=rTrim(s);
		return s;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		String[] newArr = new String[arr.length];
		for(int i=0 ; i<arr.length ; i++){
			newArr[i]=String.valueOf(arr[i]);
		}
		return newArr;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		int[] newArr = new int[arr.length];
		for(int i=0 ; i<arr.length ; i++){
			newArr[i]=Integer.parseInt(arr[i]);
		}
		return newArr;
	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		int max=0;
		for(int i=0 ; i<arr.length ; i++){
			if(arr[i].length()>max){
				max=arr[i].length();
			}
		}
		return max;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c)
	{
		int max = maxLength(arr);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].length()<max){
				arr[i]=lpad(arr[i],max-arr[i].length(), c);
			}
		}
	}

	public static int indexOfN(String s,char c,int n){
		int index=-1;
		int count=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==c){
				count++;
				if (count == n) {
					index = i;
				}
			}
		}
		return index;
	}
}
