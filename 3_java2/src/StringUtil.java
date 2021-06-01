import java.util.ArrayList;

public class StringUtil
{

	static ArrayList<String> L0 = new ArrayList<>();
	static ArrayList<String> L1 = new ArrayList<>();
	static ArrayList<String> L2 = new ArrayList<>();
	static ArrayList<String> L3 = new ArrayList<>();
	static ArrayList<String> L4 = new ArrayList<>();
	static ArrayList<String> L5 = new ArrayList<>();
	static ArrayList<String> L6 = new ArrayList<>();
	static ArrayList<String> L7 = new ArrayList<>();
	static ArrayList<String> L8 = new ArrayList<>();
	static ArrayList<String> L9 = new ArrayList<>();


	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n)
	{
		//Implementación
		return null;
	}
	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c)
	{
		return String.format("%"+n+"s",s).replace( ' ',c );
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int[] arr)
	{
		String[] cadenaTranformada = new String[arr.length] ;

		for (int i = 0; i < arr.length; i++) {
			cadenaTranformada[i] = String.valueOf(arr[i]);
		}
		return cadenaTranformada;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		int[] listaInt = new int[arr.length];

		for (int i = 0; i < arr.length ; i++) {
			listaInt[i] = Integer.valueOf(arr[i]).intValue();
		}
		return listaInt;
	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		int mayorTamano = 0;
		for (String dato: arr) {
			if(	dato.length()>mayorTamano){
				mayorTamano =dato.length();
			}
		}
		return mayorTamano;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c)
	{
		int mayorTamano = maxLength(arr);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = lpad(arr[i],mayorTamano,c);
		}
	}

	public static void agregarEnArregloAdecuado(String elemento, int columnaARevisar){



		switch (String.valueOf(elemento.charAt( (elemento.length()-1) - (columnaARevisar) ))){
			case "0": L0.add(elemento);
				break;

			case "1": L1.add(elemento);
				break;

			case "2": L2.add(elemento);
				break;

			case "3": L3.add(elemento);
				break;

			case "4": L4.add(elemento);
				break;

			case "5": L5.add(elemento);
				break;

			case "6": L6.add(elemento);
				break;

			case "7": L7.add(elemento);
				break;

			case "8": L8.add(elemento);
				break;

			case "9": L9.add(elemento);
				break;

			default: break;
		}

	}

	public static String[] armarLista(int tamanoArray){
		ArrayList<String> arregloArmado = new ArrayList<>();
		String[] cadenaArmada = new String[tamanoArray];
		ArrayList<ArrayList<String>> arreglosUnidos = new ArrayList<>();
		arreglosUnidos.add(L0);
		arreglosUnidos.add(L1);
		arreglosUnidos.add(L2);
		arreglosUnidos.add(L3);
		arreglosUnidos.add(L4);
		arreglosUnidos.add(L5);
		arreglosUnidos.add(L6);
		arreglosUnidos.add(L7);
		arreglosUnidos.add(L8);
		arreglosUnidos.add(L9);


		for (ArrayList<String> listaL: arreglosUnidos) {
			for (String elemento:listaL) {
				arregloArmado.add(elemento);
			}
		}

		L0.clear();
		L1.clear();
		L2.clear();
		L3.clear();
		L4.clear();
		L5.clear();
		L6.clear();
		L7.clear();
		L8.clear();
		L9.clear();

		for (int i = 0; i < cadenaArmada.length; i++) {
			cadenaArmada[i] = arregloArmado.get(i);
		}
		return cadenaArmada;
	}

	public static String Rpad(String s,int n,char c)
	{
		return String.format("%-"+n+"s",s).replace( ' ',c );
	}

	public static String rtrim(String s){

		while (s.charAt(s.length()-1) == ' '){
			s = s.substring(0,s.length()-1);
		}
		return s;

	}

	public static String trim (String s){
		return s.trim();
	}

	public static int indexOfN(String s, char c, int n){
		//int contador = 0;
		int index = -1;
		for (int i = 0, contador = 0; i <s.length() && contador < n; i++) {
			if(s.charAt(i) == c){
				contador++;
			}
			if (contador == n){
				index = i;
			}
		}

		return index;
	}

	public static void main(String[] args) {
		System.out.println(Rpad("1",5,'0'));
		System.out.println(rtrim("   P ruebas    "));
		System.out.println(trim("      Pru  ebas    "));

		System.out.println(indexOfN("John|Paul|George|Ringo",'|',3));
	}
}
