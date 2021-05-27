package com.company;

import java.util.regex.Pattern;

public class PasswordSimple extends Password {

	public PasswordSimple(String password) {
		super(Pattern.compile("[a-zA-Z]"));
		setPassword(password);
	}
}
