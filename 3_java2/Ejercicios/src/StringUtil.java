public class StringUtil {

    // Agrega caracteres a la derecha del string.  n = longitud, c = caracter a agregar
    public static String rpad(String s, char c, int n) {

        int toAdd = n - s.length();

        if (toAdd > 0) {
            s += replicate(c, toAdd);
        }
        return s;
    }

    // Retorna una cadena identica a s pero sin espacios a la izquierda
    public static String ltrim(String s) {

        int i = 0;

        while (Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        return s.substring(i);
    }

    // Retorna una cadena identica a s pero sin espacios a la derecha
    public static String rtrim(String s) {

        int i = s.length() - 1;

        while (i >= 0 && Character.isWhitespace(s.charAt(i))) {
            i--;
        }
        return s.substring(0, i + 1);
    }

    // Retorna una cadena identica a s pero sin espacios a la izquierda/derecha
    public static String trim(String s) {

        s = ltrim(s);
        s = rtrim(s);

        return s;
    }

    // Retorna la posicion de la n-esima ocurrencia del caracter c dentro del string
    public static int indexOfN(String s, char c, int n) {

        int i = 0, count = 0, pos = -1;

        while (count < n && i < s.length()) {

            if (s.charAt(i) == c) {
                count++;
                pos = i;
            }

            i++;
        }
        return pos;
    }

    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c, int n) {
        String newString = "";

        for (int i = 0; i < n; i++) {
            newString = c + newString;
        }

        return newString;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s, int n, char c) {
        int toAdd;

        toAdd = n - s.length();
        return replicate(c, toAdd) + s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[]) {
        String[] string = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {

            string[i] = Integer.toString(arr[i]);
        }

        return string;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[]) {
        int[] newInt = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            newInt[i] = Integer.parseInt(arr[i]);
        }

        return newInt;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[]) {
        int maxLengthItem = 0;

        for (String s : arr) {

            if (maxLengthItem < s.length()) {
                maxLengthItem = s.length();
            }
        }

        return maxLengthItem;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor (usa lpad)
    public static void lNormalize(String arr[], char c) {
        int maxlenghtItem = maxLength(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = lpad(arr[i], maxlenghtItem, c);
        }
    }
}
