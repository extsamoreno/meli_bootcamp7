package practicaTT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private Pattern patron;
    private String value;

    public Password() {

    }

    public Password(String reg) {
        this.patron = Pattern.compile(reg);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String pwd) throws IllegalArgumentException {
        Matcher matcher = patron.matcher(pwd);
        boolean matchFound = matcher.find();
        if (matchFound)
            this.value = pwd;
        else
            throw new IllegalArgumentException("Password not valid");

    }
}
