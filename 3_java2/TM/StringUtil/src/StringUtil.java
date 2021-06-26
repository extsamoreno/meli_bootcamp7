public class StringUtil {

    public static String rpad (String s, char c, int n) {
        return s + replicate(c, n-s.length());
    }

    public static String ltrim (String s) {
        return s.replaceAll("^\\s*","");
    }

    public static String rtrim (String s) {
        return s.replaceAll("\\s*$","");
    }

    public static String trim (String s) {
        ltrim(s);
        rtrim(s);
        return s;
    }

    public static int indexOfN (String s, char c, int n) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            index = s.indexOf(c, index + 1);
        }
        return index;
    }

    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String s="";
        for(int i=0; i<n; i++)
        {
            s+=c;
        }
        return s;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        return replicate(c,n-s.length())+s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String sArr[]=new String[arr.length];
        for(int i=0; i<arr.length; i++)
        {
            sArr[i]=Integer.toString(arr[i]);
        }
        return sArr;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int iArr[]=new int[arr.length];
        for(int i=0; i<arr.length; i++)
        {
            iArr[i]=Integer.parseInt(arr[i]);
        }
        return iArr;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int i=0;
        int max=arr[i].length();
        for(String s:arr)
        {
            if(s.length()>max)
            {
                max=s.length();
            }
        }
        return max;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c)
    {
        int max=maxLength(arr);
        for(int i=0; i<arr.length;i++)
        {
            arr[i]=lpad(arr[i],max,c);
        }
    }
}
