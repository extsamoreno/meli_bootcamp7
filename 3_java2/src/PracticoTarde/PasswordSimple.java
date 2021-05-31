package PracticoTarde;

public class PasswordSimple extends Password{
    private static final String PASS_PATTERN = "/(\\d)/g";

    public PasswordSimple() {
        super(PASS_PATTERN);
    }



}
