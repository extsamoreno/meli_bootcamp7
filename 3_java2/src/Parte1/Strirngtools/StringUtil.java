package Parte1.Strirngtools;

public class StringUtil {

    private static String fill(char c, int n ){
        String s = "";
        while(n!= 0){
            s += c;
            n--;
        }
        return s;
    }

    /*Rellenar con c en a  la derecha hasta alcanzar la cantidad n
    *
    * "Hola" -> "Hola!!!!!!!!";
    *
    * */

    public static String rpad(String s, char c,int n){
        int diff = n - s.length();
        return s +  fill(c, diff);
    }

    /*
     * Reemplazar espacios en blanco a la izquierda
     * */

    public static String ltrim(String s){
        while (s.startsWith(" ")){
            if (s.startsWith(" ")){
                s = s.substring(1,s.length());
            }
        }
        return s;
    }

    /*
     * Reemplazar espacios en blanco a la derecha
     * */
    public static String rtrim(String s){
        while (s.endsWith(" ")){
            if (s.endsWith(" ")){
                s = s.substring(1,s.length());
            }
        }
        return s;
    }

    /*
    * Retorna el indice de el chart c, dependiendo de las ocurrencias n
    * si no lo encuentra retorna -1
    *
    * */
    public static int indexOfN(String s,char c,int n) {
        int count = 0;
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) { //danielalejandro
            if (ch[i] == c) {
                count++;
                if (count == n) {
                    return i;
                }
            }
        }
        return -1;

    }






}
