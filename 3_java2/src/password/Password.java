package password;

import java.util.InvalidPropertiesFormatException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class  Password {
    private Pattern pattern;
    private String password;

    public Password(String regex) {
        pattern = Pattern.compile(regex);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws IllegalArgumentException {
        Matcher match = pattern.matcher(password);
        if (match.find()) {
            this.password = password;
        } else {
            //Validar exception
            throw new IllegalArgumentException("Error del regex");
        }
    }
}


