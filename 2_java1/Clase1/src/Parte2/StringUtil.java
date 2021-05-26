package Parte2;

public class StringUtil
{

    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String newString = String.valueOf(c);
        String returnString = "";
        while (n != 0){
            returnString += newString;
            n--;
        }
        return returnString;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        int diff = n - s.length();
        return replicate(c, diff) + s;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[], char c)
    {
        int longitud = Integer.valueOf(c);
        for (int i = 0; i < arr.length; i++) {
            if ( arr[i].length() < longitud){
                String s = "0";
                char ch = s.charAt(0);
                arr[i] = lpad(arr[i], longitud, ch);
            }
        }
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String[] stringArray = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            stringArray[i] = String.valueOf(arr[i]);
        }
        return  stringArray;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int[] intArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArray[i] = Integer.valueOf(arr[i]);
        }
        return  intArray;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int longitud = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > longitud){
                longitud = arr[i].length();
            }
        }
        return longitud;
    }

}
