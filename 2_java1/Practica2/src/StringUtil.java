public class StringUtil {
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String cadena = "";
        for(int i=1;i<=n;i++){
            cadena = cadena + c;
        }
        return cadena;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        String cadena = s;
        int len = s.length();
        for(int i=len;i<n;i++){
            cadena = c + cadena;
        }
        return cadena;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String newArray[] = new String[arr.length];
        for(int i=0; i < arr.length; i++){
            newArray[i] = Integer.toString(arr[i]);
        }
        return newArray;
    }

    // Retorna un int[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int newArray[] = new int[arr.length];
        for(int i=0; i < arr.length; i++){
            newArray[i] = Integer.parseInt(arr[i]);
        }
        return newArray;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int maxLen = 0;
        for(String i: arr){
            int len = i.length();
            if(len > maxLen){
                maxLen = len;
            }
        }
        return maxLen;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c)
    {
        int len = maxLength(arr);
        String temp[] = new String[arr.length];
        for(int i=0; i< arr.length; i++) {
           temp[i]  = lpad(arr[i], len, c);
           arr[i] = temp[i];
        }

    }
}
