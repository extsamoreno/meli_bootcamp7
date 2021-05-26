public class StringUtil {
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n) {
        String string = "";
        while(string.length() < n){
            string += c;
        }

        return string;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c) {
        int large = n - s.length();
        return replicate(c, large) + s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[]) {
        String arrString[] = new String[arr.length];

        for(int i = 0; i < arr.length; i++){
            arrString[i] = String.valueOf(arr[i]);
        }

        return arrString;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[]) {
        int intString[] = new int[arr.length];

        for(int i = 0; i < intString.length; i++){
            intString[i] = Integer.parseInt(arr[i]);
        }

        return intString;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[]) {
        int maxLarge = arr[0].length();

        for(int i = 0; i < arr.length; i ++){
            if(arr[i].length() > maxLarge) maxLarge = arr[i].length();
        }

        return maxLarge;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c) {
        int large = maxLength(arr);

        for(int i = 0; i < arr.length; i++){
            arr[i] = lpad(arr[i], large, c);
        }
    }
}
