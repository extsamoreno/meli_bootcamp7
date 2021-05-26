package com.company;

public class StringUtils {
    public static String[] getStringList(int[] iArr) {
        String[] sArr = new String[iArr.length];

        for (int i = 0; i < iArr.length; ++i)
            sArr[i] = Integer.toString(iArr[i]);

        return sArr;
    }

    public static int getLongest(String[] sArr) {
        int m = 0;

        for (var s: sArr)
            if (s.length() > m)
                m = s.length();

        return m;
    }

    public static String normalize(String number, int amount) {
        String m = number;

        for (int i = 0; i+number.length() < amount; ++i)
            m = "0"+m;

        return m;
    }

    public static String[] getNormalizedStringList(int[] iArr) {
        String[] sArr = getStringList(iArr);
        String[] nArr = new String[sArr.length];

        int l = getLongest(sArr);

        for (int i = 0; i < nArr.length; ++i)
            nArr[i] = normalize(sArr[i], l);

        return nArr;
    }
}
