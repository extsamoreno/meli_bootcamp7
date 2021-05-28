import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public abstract class Password {
    private Pattern pattern;
    private String password;
    private Matcher match;
    public Password(String regex) {
        this.pattern = Pattern.compile(regex);

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.match = this.pattern.matcher(password);
        if (!this.match.matches())
            throw new PatternSyntaxException("Password", this.password, 1);
        else
            this.password = password;

    }
}
