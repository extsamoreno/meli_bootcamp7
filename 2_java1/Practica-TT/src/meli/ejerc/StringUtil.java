package meli.ejerc;

public class StringUtil
{
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
        for (int i=0; i<=(n-(s.length())); i++){
            s=s+c;
        }
        return s;
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
            String relleno = Character.toString(c);
            if (mayorLongitud>arr[i].length()){
                for (int n = 1 ; n<(mayorLongitud-(arr[i].length())); n++){
                    relleno=relleno+c;
                }
                arr[i]=relleno+arr[i];
            }
        }
        return arr;
    }
}