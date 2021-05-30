package TT.Exercise1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private String password,regex;

    public Password(String regex) {
        this.regex = regex;
    }
    public void setValue(String password) throws Exception {
        Pattern pattern = Pattern.compile(this.regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches())
            this.password = password;
        else throw new Exception("Password no cumple requisitos");
    }
}

