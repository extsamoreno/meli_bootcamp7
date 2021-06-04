package definitivotarde;

public class StringUtil {
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c, int n) {
        String cadena = "";
        for (int i = 0; i < n; i++) {
            cadena += c;
        }
        return cadena;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s, int n, char c) {
        int prefixLarge = n - s.length(); //para saber la cantidad de c que necesito agregar
        return replicate(c, prefixLarge) + s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[]) {
        String[] arrString = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrString[i] = Integer.toString(arr[i]);
        }
        return arrString;
    }

    // Retorna un int[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[]) {
        int[] intArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArray[i] = Integer.parseInt(arr[i]);
        }
        return intArray;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i].length()) max = arr[i].length();
        }
        return max;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[], char c) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]= lpad(arr[i], maxLength(arr), c);
        }
    }
}
