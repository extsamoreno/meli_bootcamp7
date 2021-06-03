package TM;

public class StringUtil
{

	public static String rpad(String s,char c,int n){
		String sCad = s;
		int cComp = n - s.length();
		for(int i = 0; i < cComp; i++){
			sCad = sCad + c;
		}
		return sCad;
	}

	public static String ltrim(String s){
		String aux = "";
		int i = 0;
		int j = 0;

		for (i=0;i<=s.length();i++) {
			if (s.charAt(i) != ' ')
				continue;
		}
		for(j=i; j<= s.length();j++){
			aux += s.charAt(j);
		}
		return aux;
	}

	public static String rtrim(String s){
		String aux = "";
		int i = 0;
		int j = 0;

		for (i=s.length();i>0;i--) {
			if (s.charAt(i) != ' ')
				continue;
		}
		for(j = i; j > s.length(); j--){
			aux += s.charAt(j);
		}
		return aux;
	}

	public static String trim(String s){
		String aux = ltrim(s);
		aux = rtrim(s);
		return aux;
	}

	//Tengo que terminar este
	/*Retorna la posición de la n-ésima
	ocurrencia del carácter c dentro de s, o -1 si s no contiene a c. Por ejemplo, si s = “John|Paul|George|Ringo”, c = ‘|’
	y n=2, la función debe retornar la posicióon de la segunda ocurrencia del carácter ‘|’ (pipe) dentro de la cadena s.
	Que, en este caso, es: 9.
	 */
	public static int indexOfN(String s,char c,int n){

		int i;
		int aux = 0;

		for(i=0; i<s.length();i++){
			if((s.charAt(i) == c)){
				aux++;
				if(aux == n) break;
			}
		}
		if(aux != n) aux = -1;

		return aux;
	}


	// Paso el test
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n)
	{
        String sCad = new String();
        for(int i=0; i<n; i++){
            sCad = sCad + c;
        }
        return sCad;
	}

	// Paso el test
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida(antes) de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c)
	{
        String sCad = s;
        int cComp = n - s.length();
		for(int i = 0; i < cComp; i++){
            sCad = c + sCad;
        }
		return sCad;
	}

	//Paso el test
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		int sizeArray = arr.length;
		String[] sArr = new String[sizeArray];
		for(int i = 0; i<sizeArray; i++) {
			sArr[i] = String.valueOf(arr[i]);
		}
		return sArr;
	}

	// Paso el test
	// Retorna un Int[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		int sizeArray = arr.length;
		int[] iArr = new int[sizeArray];
		for(int i=0; i< sizeArray; i++){
			iArr[i] = Integer.valueOf(arr[i]);
		}
		return iArr;
	}
	
	// Paso el test
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
        int maxSize = 0;
	    for(int i = 0; i<arr.length; i++) {
            if(arr[i].length() > maxSize)
	            maxSize = arr[i].length();
        }
        return maxSize;
	}

	// Paso el test
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c)
    {
        int maxSize = maxLength(arr);
        int size;
        for(int i = 0; i<arr.length; i++) {
		    size = arr[i].length();
            if (size < maxSize){
                for (int j=0;j< (maxSize-size);j++)
                    arr[i] = c + arr[i];
            }
        }
	}
}
