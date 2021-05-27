package com.company;

public class StringUtil {
	public static String rpad(String s, char c, int n) {
		return s+String.valueOf(c).repeat(n);
	}

	public static String lpad(String s, char c, int n) {
		return String.valueOf(c).repeat(n)+s;
	}

	public static String rtrim(String s) {
		boolean t = true;

		StringBuilder ns = new StringBuilder();
		for (int i = s.length() - 1; i >= 0 && s.charAt(i) == ' '; --i)
			ns.append(s.charAt(i));

		return ns.toString();
	}

	public static String ltrim(String s) {
		StringBuilder ns = new StringBuilder();
		for (int i = 0; i < s.length() && s.charAt(i) == ' '; ++i)
			ns.append(s.charAt(i));

		return ns.toString();
	}

	public static String trim(String s) {
		return ltrim(rtrim(s));
	}

	public static int indexOfN(String s, char c, int n) {
		for (int i = 0, j = 0; j < s.length(); ++j) {
			if (s.charAt(j) == c) {
				++i;
				if (i == n)
					return j;
			}
		}

		return -1;
	}
}
