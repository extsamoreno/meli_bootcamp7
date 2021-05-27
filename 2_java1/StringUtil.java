import java.util.Collections;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        //Implementación
        String replicate="";
        for (int i = 0; i < n; i++) {
            replicate+=c;
        }
        return replicate;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        return s+replicate(c,n);
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        //Implementación
        String[] myStr = new String[arr.length];
        for (int i =0; i<arr.length; i++){
            myStr[i] = Integer.toString(arr[i]);
        }
        return myStr;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        //Implementación
        return null;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        //Implementación
        int maxLength =0;
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
        int max = maxLength(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length() < max){
                lpad(arr[i],max-arr[i].length(),c);
            }
        }
    }
}