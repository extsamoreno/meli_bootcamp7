import java.util.ArrayList;
import java.util.HashMap;

public class StringUtils
{
    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c,int n)
    {
        //Implementación
        String strReplicatedChar = "";
        for (int i = 0; i < n; i++) {
            strReplicatedChar += c;
        }
        return strReplicatedChar;


    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s,int n,char c)
    {
        //Implementación
        return replicate(c ,n - s.length()) + s;

    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int[] arr)
    {
        //Implementación
        String[] myStrArr = new String[arr.length];
        for (int i=0; i<arr.length; i++){
            myStrArr[i] = Integer.toString(arr[i]);
        }
        return myStrArr;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String[] arr)
    {
        //Implementación
        int[] myIntArr = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            myIntArr[i] = Integer.parseInt(arr[i]);
        }
        return myIntArr;
    }


    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String[] arr)
    {
        //Implementación
        int maxLen = 0;
        for (String s : arr) {
            if (s.length() > maxLen) {
                maxLen = s.length();
            }
        }
        return maxLen;
    }

    public static int maxIntLength(int[] arr)
    {
        //Implementación
        int maxLen = 0;
        for (int n : arr) {
            if (Integer.toString(n).length() > maxLen) {
                maxLen = Integer.toString(n).length();
            }
        }
        return maxLen;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String[] arr,char c)
    {
        //Implementación
        int maxStrLen = maxLength(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = lpad(arr[i], maxStrLen, c);
        }
    }

    public static HashMap<Integer, ArrayList<String>> emptyHashMap()//keys 0 to 9
    {
        HashMap<Integer, ArrayList<String>> myHash = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            myHash.put(i, new ArrayList<>());
        }
        return myHash;
    }

    public static void toHashMap(String[] strArr, int digitIndex, HashMap<Integer, ArrayList<String>> hashMap)
    {
        for (String s: strArr)
        {
            int k = s.charAt(digitIndex) - 48; //for '0' .charAt returns 48 from ascii
            hashMap.get(k).add(s);
        }
    }

    public static ArrayList<String> fromHMapToStrArrayList(HashMap<Integer, ArrayList<String>> hashMap)
    {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int k = 0; k < 10; k++) {
            for (String numStr: hashMap.get(k)) {
                stringArrayList.add(numStr);
            }
        }
        hashMap.clear();
        return stringArrayList;
    }

    public static String[] toStrArray(ArrayList<String> arrayList)
    {
        String[] strArr = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            strArr[i] = arrayList.get(i);
        }
        return strArr;
    }

    public static String[] sort(String[] sArr, int digit, HashMap hashMap)
    {
        StringUtils.toHashMap(sArr, digit, hashMap);
        ArrayList<String> strArrL = StringUtils.fromHMapToStrArrayList(hashMap);
        String[] newStrArray = StringUtils.toStrArray(strArrL);
        return newStrArray;
    }

    public static int[] myRadixSort(int[] arr, int d)
    {
        String[] strArray = toStringArray(arr);
        lNormalize(strArray, '0');
        HashMap<Integer, ArrayList<String>> hashMap = emptyHashMap();
        strArray = sort(strArray, d, hashMap);
        return toIntArray(strArray);
    }

    /*
     - public static String rpad(String s,char c,int n); idem lpad, pero agregando caracteres a la derecha.
     - public static String ltrim(String s); Retorna una cadena idéntica a s pero sin espacios a la izquierda.
     - public static String rtrim(String s); idem ltrim, pero sin espacios a la derecha.
     - public static String trim(String s); idem lpad, pero sin espacios a derecha ni izquierda.
     - public static int indexOfN(String s,char c,int n); Retorna la posición de la n-ésima
        ocurrencia del carácter c dentro de s, o -1 si s no contiene a c. Por ejemplo,
        si s = “John|Paul|George|Ringo”, c = ‘|’ y n=2, la función debe retornar la posicióon de la
        segunda ocurrencia del carácter ‘|’ (pipe) dentro de la cadena s. Que, en este caso, es: 9.
     */

    public static String rpad(String s,char c,int n)
    {
        //Implementación
        return s + replicate(c ,n - s.length());

    }

    public static String ltrim(String s)
    {
        int ind = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
            {
                continue;
            }
            else
            {
                ind = i;
            }
        }
        return s.substring(ind);
    }

    public static String rtrim(String s)
    {
        int ind = 0;
        for (int i = s.length() -1; i <= 0; i--)
        {
            if (s.charAt(i) == ' ')
            {
                continue;
            }
            else
            {
                ind = i;
            }
        }
        return s.substring(0,ind+1);
    }

    public static String trim(String s)
    {
        String sTrimmed = ltrim(s);
        return rtrim(sTrimmed);
    }

    public static int indexOfN(String s,char c,int n)
    {
        int count = 0;
        int ind = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == c) {
                count++;
                if (count == n)
                {
                    ind = i;
                    break;
                }
            }
        }
        return ind;
    }

}
