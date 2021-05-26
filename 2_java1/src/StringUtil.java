
public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        //Implementación
        String temp= "";
        for (int i=0; i<n; i++){
            temp+=c;
        }
        return temp;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        //Implementación
        String sTemp=s;
        for (int i=0; i<n-s.length(); i++){
            sTemp=c+sTemp;
        }
        return sTemp;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        //Implementación
        String[] sArr= new String[arr.length];
        for (int i=0; i<arr.length; i++){
            sArr[i]=arr[i]+"";
        }
        return sArr;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        //Implementación
        int[] sArr= new int[arr.length];
        for (int i=0; i<arr.length; i++){
            sArr[i]=Integer.parseInt(arr[i]);
        }
        return sArr;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        //Implementación
        int max=0;
        for (int i=0; i<arr.length; i++){
            if (arr[i].length()>max) max=arr[i].length();
        }
        return max;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c)
    {
        //Implementación
        int maxLength=maxLength(arr);
        for (int i=0; i<arr.length; i++){
            arr[i]=lpad(arr[i],maxLength,c);
        }
    }
}
