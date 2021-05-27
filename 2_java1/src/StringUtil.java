public class StringUtil {
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        return "";
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s, int n, char c) {
        return String.format("%0"+n+"d", Integer.parseInt(s));
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[]) {
        String[] str = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            str[i] = String.valueOf(arr[i]);
        }
        return str;
    }
    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[]) {
        int[] str = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            str[i] = Integer.parseInt(arr[i]);
        }
        return str;
    }
    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[]) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > j) {
                j = arr[i].length();
            }
        }
        return j;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[], char c) {

    }
}
