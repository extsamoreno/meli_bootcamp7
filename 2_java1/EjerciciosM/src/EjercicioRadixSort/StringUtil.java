package EjercicioRadixSort;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String s = String.valueOf(c);
        return s.repeat(n);
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        var replica = replicate(c, n);
        return replicate(c, n) + s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String[] listaString = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            listaString[i] = Integer.toString(arr[i]);
        }

        return  listaString;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int[] listaNums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            listaNums[i] = Integer.parseInt(arr[i]);
        }

        return listaNums;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int maxLength = 0;
        for (String x : arr){
            if (x.length() > maxLength){
                maxLength = x.length();
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
            if (arr[i].length() < max){
                int faltante = max - arr[i].length();
                arr[i] = lpad(arr[i], faltante, c);
            }
        }
    }
}