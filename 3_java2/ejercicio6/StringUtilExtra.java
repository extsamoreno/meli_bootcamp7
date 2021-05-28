package ejercicio6;

public class StringUtilExtra {
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n) {
        String cadena = "";

        for (int i = 0; i < n; i++) {
            cadena = cadena + c;
        }

        return cadena;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada (izquierda)
    public static String lpad(String s,int n,char c) {
        String cadena = "";

        for(int i = 0; i < n-s.length(); i++){
            cadena = cadena + c;
        }
        cadena = cadena + s;

        return cadena;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y procedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada a la (derecha)
    public static String rpad(String s, char c, int n) {
        String cadena = "";

        cadena = cadena + s;

        for(int i = 0; i < n-s.length(); i++){
            cadena = cadena + c;
        }

        return cadena;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[]) {
        String String[] = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            String[i] = Integer.toString(arr[i]);
        }

        return String;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[]) {
        int String[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            String[i] = Integer.parseInt(arr[i]);
        }

        return String;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[]) {
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length() > maxLength){
                maxLength = arr[i].length();
            }
        }

        return maxLength;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[],char c) {
        int maxLength = maxLength(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = lpad(arr[i], maxLength, c);
        }
    }

    //Retorna una cadena idéntica a s pero sin espacios a
    //la izquierda
    public static String ltrim (String s){
        String cadena = "";
        int i = 0;

        while(s.charAt(i) == ' '){
            i++;
        }

        for(int j = i; j < s.length(); j++){
            cadena = cadena + s.charAt(j);
        }

        return cadena;
    }

    //Retorna una cadena idéntica a s pero sin espacios a
    //la derecha
    public static String rtrim (String s){
        String cadena = "";
        int i = 0;

        while(s.charAt(i) != ' '){
            i++;
        }

        for(int j = 0; j < i; j++){
            cadena = cadena + s.charAt(j);
        }

        return cadena;
    }

    //Retorna una cadena idéntica a s pero sin espacios a
    //la derecha y a la izquierda
    public static String trim (String s){
        String cadenaLTrim = rtrim(s);
        String cadenaTrim = ltrim(cadenaLTrim);

        return cadenaTrim;
    }

    //Retorna la posición de la n-ésima
    //ocurrencia del carácter c dentro de s, o -1 si s no
    // contiene a c.
    public static int indexOfN(String s,char c,int n){
        int index = 0;
        int counter = 0;

        for(int i = 0; i < s.length(); i++ ){
            if(s.charAt(i) == c){
                counter++;

                if(counter == n){
                    index = i;
                    break;
                }
            }
        }

        return index;
    }
}