public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String svuelta;
        svuelta = "";
        for(int i=0;i<n;i++){
            svuelta = svuelta + c;
        }
        return svuelta;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        String scad = replicate(c,n);
        return scad + s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        int len;
        len = arr.length;
        String arr_str[] = new String[len];
        for(int i=0; i<len; i++){
            arr_str[i] = Integer.toString(arr[i]);
        }
        return arr_str;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int len;
        len = arr.length;
        int arr_int[] = new int[len];
        for(int i=0; i<len; i++){
            arr_int[i] = Integer.parseInt(arr[i]);
        }
        return arr_int;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int may = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i].length()>may){
                may = arr[i].length();
            }
        }
        return may;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c)
    {
        int may;
        may = maxLength(arr);

        for(int i=0; i<arr.length; i++){
            int completar = may - arr[i].length();
            arr[i] = lpad(arr[i],completar,c);
        }
    }
}