package tm;

public class StringUtil {

    public static String[] intArrayToStringArray(int[] intArray) {
        String[] salida = new String[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            salida[i] = String.valueOf(intArray[i]);
        }
        return salida;
    }

    public static int maxLongitudElementoStringArray(String[] stringArray) {
        int mayorLongitud = 0;
        for (String elemento : stringArray) {
            if (elemento.length() > mayorLongitud) mayorLongitud = elemento.length();
        }
        return mayorLongitud;
    }

    public static String lpad(String cadena, int longitud, char caracter) {
        String caracteres = replicate(caracter, longitud - cadena.length());
        cadena = caracteres.concat(cadena);
        return cadena;
    }

    public static String rpad(String cadena, int longitud, char caracter) {
        String caracteres = replicate(caracter, longitud - cadena.length());
        cadena = cadena.concat(caracteres);
        return cadena;
    }

    public static String ltrim(String s) {
        while (s.startsWith(" ")) {
            s = s.substring(1);
        }
        return s;
    }

    public static String rtrim(String s) {
        while (s.endsWith(" ")) {
            s = s.substring(0, s.length() - 2);
        }
        return s;
    }

    public static String trim(String s) {
        s = StringUtil.ltrim(s);
        s = StringUtil.rtrim(s);
    }

    public static int indexOfN(String s,char c,int n) {
        int contadorLetra = 0;
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                contadorLetra++;
                if (contadorLetra == n) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void normalizarElementosStringArray(String[] stringArray, char caracter) {
        int mayorLongitud = maxLongitudElementoStringArray(stringArray);
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = lpad(stringArray[i], mayorLongitud, caracter);
        }
    }

    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c, int n) {
        String caracter = String.valueOf(c);
        String salida = "";
        for (int i = 0; i < n; i++) salida = salida.concat(caracter);
        return salida;
    }

    // Retorna un int[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[]) {
        int[] salida = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            salida[i] = Integer.parseInt(arr[i]);
            System.out.println(salida[i]);
        }
        return salida;
    }

}
