package Eje1;
import java.util.ArrayList;
import java.util.HashMap;

public class StringUtil {
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        String replicada = "";

        for (int i = 0; i < n; i++) {
            replicada += c;
        }
          return replicada;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        String rta;
        rta=replicate(c,n-s.length()) + s;

        return rta;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String[] rta= new String[arr.length];

        for (int i = 0; i < arr.length ; i++) {
            rta[i]= String.valueOf(arr[i]);
        }
        return rta;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int[] rta= new int[arr.length];

        for (int i = 0; i < arr.length ; i++) {
            rta[i]= Integer.valueOf(arr[i]);
        }
        return rta;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
      int maxLargo=0;
        for (int i = 0; i < arr.length ; i++) {
           if (arr[i].length()>maxLargo){
               maxLargo=arr[i].length();
           }
        }
      return maxLargo;
    }


    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c)
    {
        int maxLength = maxLength(arr);
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = lpad(arr[i],maxLength,c);
        }

    }
}
