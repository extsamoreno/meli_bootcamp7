public class StringUtils {

    public static String rpad(String s,int n,char c)
    {
        return s+replicate(c,n);
    }

    public static String replicate(char c,int n)
    {
        String replicate="";
        for (int i = 0; i < n; i++) {
            replicate+=c;
        }
        return replicate;
    }

    public static String ltrim(String s) {
        int i = 0;
        while(i < s.length() && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        return s.substring(i);
    }

    public static String rtrim(String s) {
        int i = s.length() - 1;
        while(i >= 0 && Character.isWhitespace(s.charAt(i))) {
            i--;
        }
        return s.substring(0,i+1);
    }

    public static String trim(String s) {
        s = ltrim(s);
        s = rtrim(s);
        return s;
    }

    public static int indexOfN(String s, char c, int n) {
        int index = -1, i = 0, ocurrencia = 0;

        while (i < s.length() && ocurrencia != n) {
            if(s.charAt(i) == c) {
                index = i;
                ocurrencia++;
            }
            i++;
        }

        if(ocurrencia != n){
            return -1;
        }

        return index;
    }

}
