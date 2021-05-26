package practicaTT;

public class StringUtil {

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[]) {
        String[] listString = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            listString[i] = String.valueOf(arr[i]);
        }
        return listString;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[]) {
        int length = arr[0].length();
        for (String x : arr) {
            if (x.length() > length) {
                length = x.length();
            }

        }
        return length;

    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[], char c) {
        int max = maxLength(arr);
        int index = 0;
        for (String x : arr) {
            x = lpad(x, max, c);
            arr[index] = x;
            index++;
        }
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s, int n, char c) {
        int faltantes = n - s.length();
        if (faltantes > 0) {
            s = replicate(c, faltantes) + s;
        }
        return s;
    }

    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c, int n) {
        String zeroString = "";

        for (int i = 0; i < n; i++) {
            zeroString += c;
        }

        return zeroString;


    }



/*
    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[]) {
        //Implementación
    }





 */
}
