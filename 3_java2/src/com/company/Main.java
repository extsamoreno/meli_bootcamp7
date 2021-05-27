package com.company;

public class Main {

    public static void main(String[] args) {
	    PasswordSimple password1 = new PasswordSimple();
	    password1.setValue("abcdef");
	    System.out.println(password1.isValid());
		PasswordMedium password2 = new PasswordMedium();
		password2.setValue("0Aa12345");
		System.out.println(password2.isValid());
		PasswordFuerte password3 = new PasswordFuerte();
		password3.setValue("@0AaBbCc12345");
		System.out.println(password3.isValid());
    }
}
