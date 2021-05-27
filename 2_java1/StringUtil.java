public class StringUtil {


    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n) {
        String resultado = "";
        for(int i = 0 ; i< n ; i++){
            resultado = resultado + c;
        }
        return resultado;
    }

    // Retorna una cadena de longitud n, compuesta por s y precedida de tantos caracteres c como sea
    // necesario para completar la longitud mencionada
    public static String lpad(String s,int n,char c) {
        int longitudIni = s.length();
        String prefix = replicate(c, n - longitudIni);

        return prefix + s;
    }

    // Retorna un String[] conteniendo los elementos de arr representados como cadenas de caracteres
    public static String[] toStringArray(int arr[]) {

        String resultado[] = new String[arr.length];
        for(int i =0 ; i< arr.length ; i++){
            resultado[i] = Integer.toString(arr[i]);
        }
        return resultado;
    }

    // Retorna un String[] conteniendo los elementos de arr representados como cadenas de caracteres
    public static int[] toIntArray(String arr[]) {
        int resultado[] = new int[arr.length];
        for(int i =0 ; i< arr.length ; i++){
            resultado[i] = Integer.parseInt(arr[i]);
        }
        return resultado;
    }


    // Retorna la longitud del elemento con mayor cantidad de caracteres del array arr
    public static int maxLength(String arr[]) {
        int max = arr[0].length();
        for(int i =1 ; i< arr.length ; i++){
            if(arr[i].length() > max){
                max = arr[i].length();
            }
        }
        return max;
    }

    // Completa los elemento del arr agregando caracteres c a la izquierda, dejando a todos
    // con la longitud del mayor
    public static void lNormalize(String arr[],char c) {
        int maxLength = maxLength(arr);

        for(int i=0 ; i< arr.length; i++){
            arr[i] = lpad(arr[i],maxLength,c);
        }

    }

//***************************************************************************
    //ejercicio 6 practica clase 2 mañana

    public static String rpad(String s,char c,int n){ //agregar caracteres a la izq
        int longitudIni = s.length();
        String prefix = replicate(c, n - longitudIni);

        return s + prefix;
    }

    //Retorna una cadena idéntica a s pero sin espacios a la izquierda.
    public static String rtrim(String s) {
        int i = s.length()-1;
        while (i >= 0 && Character.isWhitespace(s.charAt(i))) {
            i--;
        }
        return s.substring(0,i+1);
    }
    //Retorna una cadena idéntica a s pero sin espacios a derecha ni izquierda.
    public static String ltrim(String s) {
        int i = 0;
        while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
            System.out.println("s.charAt(i)  "+s.charAt(i));
            i++;
        }
        return s.substring(i);
    }


    //Retorna la posición de la n-ésima
    //ocurrencia del carácter c dentro de s, o -1 si s no contiene a c. Por ejemplo,
    //si s = “John|Paul|George|Ringo”, c = ‘|’ y n=2, la función debe retornar la posicióon de la
    //segunda ocurrencia del carácter ‘|’ (pipe) dentro de la cadena s. Que, en este caso, es: 9.
    public static int indexOfN(String s,char c,int n){
        int i=0;
        int cont=0;
        while( i<s.length() ) {
            if( s.charAt(i)==c) {
                cont++;
                if(cont == n){
                    return i;
                }
            }
            i++;
        }
        return -1;

    }









}