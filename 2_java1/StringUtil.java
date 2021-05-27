public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            builder.append(c);
        }

        return builder.toString();
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        int diff = n - s.length();
        return replicate(c, diff) + s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String[] stringArray = new String[arr.length];

        for (int i = 0; i < arr.length; i++)
        {
            stringArray[i] = String.valueOf(arr[i]);
        }
        return  stringArray;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int[] intArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++)
        {
            intArray[i] = Integer.valueOf(arr[i]);
        }
        return  intArray;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int longitud = 0;

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i].length() > longitud)
            {
                longitud = arr[i].length();
            }
        }
        return longitud;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c)
    {
        int maxLength = maxLength(arr);

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = lpad(arr[i], maxLength, c);
        }
    }
}
