package com.company;

public class Main {

	public static void main(String[] args) {
		String s = "Hello, World!";

		System.out.println(StringUtil.indexOfN(s, 'l', 3));
		System.out.println(StringUtil.rpad(s, 'λ', 5));
		System.out.println(StringUtil.lpad(s, 'Ω', 5));
		System.out.println(StringUtil.ltrim("    asdf asdf "));
		System.out.println(StringUtil.rtrim("    asdf asdf "));
		System.out.println(StringUtil.trim("    asdf asdf "));
	}
}
