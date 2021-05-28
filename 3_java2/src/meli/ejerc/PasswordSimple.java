package meli.ejerc;

public class PasswordSimple extends Password {
    private final static String REGEXP = "^(?=.*[0-9]).{8,20}$";

    public PasswordSimple() {
        super(REGEXP);
    }
}
