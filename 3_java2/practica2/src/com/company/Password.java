package com.company;

import java.util.regex.Pattern;

public abstract class Password {

	Pattern m_pattern;
	String m_password;

	public Password(Pattern pattern) {
		m_pattern = pattern;
	}

	public void setPassword(String password) {
		
		if (m_pattern.matcher(password).find()) {
			m_password = password;
			System.out.println("Contraseña aceptada.");
		}
		else {
			System.out.println("Contraeña no cumple requisitos.");
		}
	}
}
