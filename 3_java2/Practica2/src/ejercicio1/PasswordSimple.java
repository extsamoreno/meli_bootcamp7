package ejercicio1;

public class PasswordSimple extends Password{

    public static final String REGEX = "^{8,20}$";

    public PasswordSimple(String value) {
        super();
        this.setRegex(value);
    }
}
