package practicaTM;

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

        for (int i = 0; i < n; i++) zeroString += c;

        return zeroString;
    }


    // Retorna un int[] conteniendo los elementos de arr
    // representados como int
    public static int[] toIntArray(String arr[]) {
        int[] listInt = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            listInt[i] = Integer.parseInt(arr[i]);
        }
        return listInt;
    }

    public static String lTrim(String s) {

        char elem = s.charAt(0);
        while (elem == ' ') {
            s = s.substring(1);
            elem = s.charAt(0);
        }

        return s;
    }

    public static String rTrim(String s) {

        char elem = s.charAt(s.length() - 1);

        while (elem == ' ') {
            s = s.substring(0, s.length() - 2);
            elem = s.charAt(s.length() - 1);
        }

        return s;
    }

    public static String trim(String s) {
        s = lTrim(s);
        s = rTrim(s);
        return s;

    }

    public static int indexOfN(String s, char c, int n) {
        int posicion = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                n--;
                if (0 == n) posicion = i;
            }
        }
        return posicion;

    }

}
