
public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	public static String replicate(char c,int n)
	{
		String output = "";
		for (int i = 0; i < n; i++) {
			output = output+c;
		}

		return output;
	}
	
	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	public static String lpad(String s,int n,char c)
	{
		return replicate(c, n-s.length())+s;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		String[] output = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {

			Integer integer = new Integer(arr[i]);
            output[i] = integer.toString();
        }

        return output;
	}
	
	// Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            output[i] = Integer.parseInt(arr[i]);
        }

        return output;
	}
	
	
	// Retorna la longitud del elemento con mayor cantidad 
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		int maxLength = 0;

		for (int i = 0; i < arr.length; i++) {

			if(arr[i].length() > maxLength){

				maxLength = arr[i].length();
			}
			
		}

		return maxLength;
	}
	
	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[],char c)
	{
		int maxLength = maxLength(arr);

		for (int i = 0; i < arr.length; i++) {

			arr[i] = lpad(arr[i], maxLength , c);
			
		}

	}
}
