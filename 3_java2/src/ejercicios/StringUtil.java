package ejercicios;

public class StringUtil {
    //Retorna la posición de la n-ésima
    //ocurrencia del carácter c dentro de s, o -1 si s no contiene a c.

    public static int indexOfN(String s,char c,int n){
        int ocurrencies=0;
        for(int i=0 ; i<s.length() ; i++ ){
            if (s.charAt(i)==c) ocurrencies++;
            if (ocurrencies==n) return i;
        }
        return -1;
    }

    //Remueve espacios al comienzo y al final
    public static String trim(String s){
        return lTrim(rTrim(s));
    }

    //Retorna una cadena idéntica a s pero sin espacios a la derecha.
    public static String rTrim (String s){
        int i = s.length()-1;
        while (i >= 0 && Character.isWhitespace(s.charAt(i))) {
            i--;
        }
        String rtrim = s.substring(0,i+1);
        return rtrim;
    }

    //Retorna una cadena idéntica a s pero sin espacios a la izquierda.
    public static String lTrim (String s){
        int i = 0;
        while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        String ltrim = s.substring(i);
        return ltrim;
    }

    //Idem lpad, pero agregando caracteres a la derecha
    public static String rpad(String s,int n,char c)
    {
        String aux=replicate(c,n);
        return s+aux;
    }

    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String cadena = Character.toString(c);
        for (int i=1; i<n; i++){
            cadena=cadena+c;
        }
        return cadena;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        String aux = replicate(c,n);
        return (aux+s);
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String[] sArray = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sArray[i] = String.valueOf(arr[i]);
        }
        return sArray;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como int[]
    public static int[] toIntArray(String arr[])
    {
        int [] iArr = new int [arr.length];
        for(int i=0; i<arr.length; i++) {
            iArr[i] = Integer.parseInt(arr[i]);
        }
        return iArr;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        String mayor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() > mayor.length()) {
                mayor = arr[i];
            }
        }
        return mayor.length();
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static String[] lNormalize(String arr[],char c)
    {
        int mayorLongitud = maxLength(arr);
        for (int i = 0 ; i < arr.length; i++){
            if (mayorLongitud>arr[i].length()){
                int longitudIndex = arr[i].length();
                String relleno=replicate(c,mayorLongitud-longitudIndex);
                arr[i]=relleno+arr[i];
            }
        }
        return arr;
    }
}