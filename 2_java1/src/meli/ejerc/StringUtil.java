package meli.ejerc;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String result = "";
        for(int i=0;i<n;i++){
            result += String.valueOf(c);
        }
        return result;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        if(s.length() >= n){
            return s;
        }

        String result = replicate(c, n);

        result = result + s;

        return result.substring(result.length() - n, result.length());

    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String sArr[] = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            sArr[i] = String.valueOf(arr[i]);
        }

        return sArr;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int sArr[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            sArr[i] = Integer.parseInt(arr[i]);
        }

        return sArr;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int maxLength = 0;
        for (String s : arr) {
            if(s.length() > maxLength){
                maxLength = s.length();
            }
        }

        return maxLength;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String[] arr,char c)
    {
        int maxLength = maxLength(arr);
        for(int i=0;i<arr.length;i++){
            arr[i] = lpad(arr[i],maxLength,c);
        }
    }
}
