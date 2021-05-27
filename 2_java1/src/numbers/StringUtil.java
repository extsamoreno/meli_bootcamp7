package numbers;

public class StringUtil {
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c, int n) {
        String res = "";
        for (int i = 0; i < n; i++) {
            res = res + c;
        }
        return res;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s, int n, char c) {
        String res = s;
        while (res.length() < n) {
            res = c + res;
        }
        return res;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[]) {
        String[] sArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sArr[i] = String.valueOf(arr[i]);
        }
        return sArr;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[]) {
        int[] iArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            iArr[i] = Integer.parseInt(arr[i]);
        }
        return iArr;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[]) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > res) {
                res = arr[i].length();
            }
        }
        return res;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[], char c) {

        int max = maxLength(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() < max) {
                arr[i] = lpad(arr[i], max, c);
            }
        }
    }
}
