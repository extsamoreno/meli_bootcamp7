package meli.ejerc;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        //Implementación
        //a 3 a=c 3=n
        //aaa
        String cadena = "";
        for (int i=0;i<n;i++) {
            cadena+=c;
        }
        return cadena;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        //Implementación
        // c es con lo que lo voy a completar
        // s=1, n=3, c=0; 001
        int largo = s.length();
        int digitosACompletar = n-largo;
        String completar =replicate(c,digitosACompletar);
        String completado = completar+s;
        return completado;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        //Implementación
        //[1,2,3]=>["1","2","3"]
        String[] list = new String[arr.length];
        for (int i = 0; i< arr.length;i++) {
            list[i]=String.valueOf(arr[i]);

        }
        return list;

    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int[] list = new int[arr.length];
        for (int i = 0;i< arr.length;i++) {
            list[i] = Integer.parseInt(arr[i]);
        }
        return list;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        //Implementación
        int maxNumber = 0;
        for (int i = 0;i<arr.length;i++) {
            if (arr[i].length()>maxNumber)
                maxNumber=arr[i].length();
        }
        return maxNumber;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c)
    {
        //Implementación
        // permite recorrer todos y cada uno llama lpad
        int large = maxLength(arr);
        for (int i = 0;i< arr.length;i++) {
            arr[i] = lpad(arr[i],large,c);
        }
    }
}
