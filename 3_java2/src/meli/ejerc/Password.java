package meli.ejerc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private String regEx;
    private String password;

    public Password(String regExp) {
        this.regEx = regExp;
    }

    public void setValue(String password) throws Exception {
        Pattern pattern = Pattern.compile(this.regEx);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            this.password = password;
        } else throw new Exception("Password no cumple requisitos");
    }
}