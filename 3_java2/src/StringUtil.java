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
        if (res.length() < n) {
            int toAdd = n - res.length();
            res = replicate(c, toAdd) + res;
        }
        return res;
    }

    public static String rpad(String s, char c, int n) {
        String res = s;
        if (res.length() < n) {
            int toAdd = n - res.length();
            res = res + replicate(c, toAdd);
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

    public static String ltrim(String s) {
        int length = s.length();
        int count = 0;
        String res = s;
        char c;
        boolean find = false;
        while (!find && count < length) {
            c = res.charAt(0);
            // System.out.println("El char es" + c);
            if (c != ' ')
                find = true;
            else {
                //   System.out.println("Entro a el else con res" + res);
                res = res.substring(1);
                // System.out.println("Entro a el else sale res" + res);
            }
            count++;
        }

        return res;
    }

    public static String rtrim(String s) {
        int length = s.length();
        int count = 0;
        String res = s;
        boolean find = false;
        while (!find && count < length) {
            int last = res.length() - 1;
            if (res.charAt(last) != ' ')
                find = true;
            else
                res = res.substring(0, last);

            count++;
        }

        return res;
    }

    public static String trim(String s) {
        String res = s;
        res = rtrim(res);
        res = ltrim(res);
        return res;
    }

    public static int indexOfN(String s, char c, int n) {
        int count = 0;
        int i = 0;
        int size = s.length();
        char cIndex = s.charAt(i);

        while (count != n && size - 1 > i) {
            if (cIndex == c) {
                count++;
            }
            i++;
            cIndex = s.charAt(i);
        }

        if (count == n) {
            return i - 1;
        }
        return -1;
    }


}
