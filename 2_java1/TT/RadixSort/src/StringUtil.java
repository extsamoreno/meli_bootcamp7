public class StringUtil {

    // Toma cualquier entero que le pases y lo convierte a string;
    // Ejemplo: 418 -> "418".

    public static String replicate(char c, int n) {
        String string = "";

        for (int i = 0; i < n; i++) {
            string += c;
        }
        return string;
    }


    // Esta función llama a replicate todas las veces
    // que haga falta, según haya diferencia de dígitos entre
    // dos números, y le agrega el caracter a la izquierda.
    // Ejemplo: n: 418, c: c, s: "41888" -> "cc418"
    public static String lpad(String s, int n, char c) {
        return replicate(c, n - s.length()) + s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[]) {
        // creo un arreglo con la misma cantidad de elementos
        // que la del arreglo pasado por parámetro
        String[] stringArray = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            stringArray[i] = Integer.toString(arr[i]);
        }
        return stringArray;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[]) {
        int[] integerArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            integerArray[i] = Integer.parseInt(arr[i]);
        }
        return integerArray;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    // Ejemplo: ["hola", "estas"] -> 5 ("estas")
    public static int maxLength(String arr[]) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i].length()) {
                max = arr[i].length();
            }
        }
        return max;
    }

    // Completa los elemento del arreglo agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    // Ejemplo: ["418", "41888"] =  ["00418", "41888"]

    public static void lNormalize(String arr[], char c) {
        int max = maxLength(arr); // Ejemplo: 5
        for (int i = 0; i < arr.length; i++) {
            arr[i] = lpad(arr[i], max, c); // Ejemplo: "cc418"
        }
    }
}
