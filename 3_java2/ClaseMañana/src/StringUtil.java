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

    //lo mismo que lpad pero agrega a la derecha
    public static String rpad(String s, int n, char c) {
        int large = n - s.length();
        return s + replicate(c, large);
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

    //retorna una cadena identica a s pero sin espacios a la izquierda
    public static String ltrim(String s) {
        while(s.indexOf(" ") == 0){
            s = s.replace(" ", "");
        }

        return s;
    }

    //retorna una cadena identica a s pero sin espacios a la derecha
    public static String rtrim(String s) {
        while(s.charAt(s.length() - 1) == ' '){
            s = s.substring(0, s.length() - 1);
        }

        return s;
    }

    //devuelve un string igual a s pero quita los espacio a la izquierda y a la derecha
    public static String trim(String s) {
        return ltrim(rtrim(s));
    }

    //retorna la posición de la n-esima ocurrencia del caracter c dentro de s
    // o -1 si s no contiene a c
    public static int indexOfN(String s, char c, int n) {
        int index = -1;
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == c){
                index = i;
                n--;
            }
            if(n == 0) break;
        }

        if(n > 0) return -1;

        return index;
    }
}
