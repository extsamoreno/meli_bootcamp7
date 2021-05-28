package ejercicios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public String password;
    public String regex;
    private static String PASSWORD_PATTERN = "^(?=.*[0-9])";

    private static Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    Matcher matcher = pattern.matcher(password);
    matcher.matches()
}

