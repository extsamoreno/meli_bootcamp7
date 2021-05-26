package Ejercicio6;

public class StringUtil {

    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String newString = "";

        for(int i = 0 ; i < n ; i++){
            newString = c + newString;
        }

        return newString;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        int toAdd;

        if(s.length() < n){

            toAdd = n - s.length();
            s = replicate(c, toAdd) + s;

        }

        return s;

    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String[] string = new String[arr.length];

        for(int i = 0 ; i < arr.length ; i++){

            string[i] = Integer.toString(arr[i]);
        }

        return string;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int[] newInt = new int[arr.length];

        for(int i = 0 ; i < arr.length ; i++){

            newInt[i] = Integer.parseInt(arr[i]);
        }

        return newInt;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int lengthItem = 0;

        for(String s : arr){

            if(lengthItem < s.length()){
                lengthItem = s.length();
            }
        }

        return lengthItem;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor (usa lpad)
    public static void lNormalize(String arr[],char c)
    {
        int lenghtItem = maxLength(arr);

        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = lpad(arr[i], lenghtItem, c);
        }
    }
}
