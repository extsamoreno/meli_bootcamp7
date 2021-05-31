package tt;

import java.util.*;

public class StringUtil {

    // Retorna un String[], ordenado de menor a mayor
    public static void order(String[] sArr) {

        int maxLength = maxLength(sArr);
        int indexCounter = 1;

        for (int i = 0; i < maxLength; i++){

            Map<Integer, List<String>> myMap = new LinkedHashMap<>();

            for (int j = 0; j < 10; j++){
                myMap.put(j, new ArrayList<>());
            }

            for (String s : sArr){

                String myIndexChar = String.valueOf(s.charAt(maxLength - indexCounter));
                int mapKey = Integer.parseInt(myIndexChar);
                myMap.get(mapKey).add(s);
            }

            int arrCounter = 0;

            for (int k = 0; k < myMap.size(); k++) {

                List<String> myList = myMap.get(k);

                if (!myList.isEmpty()) {

                    for (String s : myList) {
                        sArr[arrCounter] = s;
                        if (arrCounter < sArr.length - 1) {
                            arrCounter++;
                        }
                    }
                }
            }
            indexCounter++;
        }
    }

    // Retorna una cadena compuesta por n caracteres c
    public static String replicate(char c, int n) {

        return String.valueOf(c).repeat(Math.max(0, n));
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    public static String lpad(String s, int n, char c) {

        return replicate(c, n) + s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int[] arr) {

        String[] sArr = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            sArr[i] = Integer.toString(arr[i]);
        }
        return sArr;
    }

    // Retorna un int[] conteniendo los elementos de sArr
    // representados como array de int
    public static int[] toIntArray(String[] sArr) {

        int[] arr = new int[sArr.length];

        for (int i = 0; i < sArr.length; i++) {

            arr[i] = Integer.parseInt(sArr[i]);
        }
        return arr;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String[] arr) {

        int maxLength = 0;

        for (String s : arr) {

            int thisLength = s.length();

            if (thisLength > maxLength) {
                maxLength = thisLength;
            }
        }
        return maxLength;
    }

    // Completa los elementos del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String[] arr, char c) {

        int maxLength = maxLength(arr);

        for (int i = 0; i < arr.length; i++) {

            StringBuilder number = new StringBuilder(arr[i]);
            int zerosToAdd = maxLength - number.length();

            while (zerosToAdd > 0) {
                number.insert(0, c);
                zerosToAdd--;
            }
            arr[i] = number.toString();
        }
    }
}
