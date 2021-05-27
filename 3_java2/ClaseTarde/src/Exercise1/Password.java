package Exercise1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private Pattern pattern;
    private String value;

    public Password() {
    }

    public Password(String reg) {
        this.pattern = pattern;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String password) throws IllegalArgumentException {
        Matcher matcher = pattern.matcher(password);
        boolean matchFound = matcher.find();
        if(matchFound) this.value = password;
        else throw new IllegalArgumentException("Invalid Exercise1.Password");
    }
}
