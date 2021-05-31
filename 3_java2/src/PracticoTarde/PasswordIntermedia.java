package PracticoTarde;

public class PasswordIntermedia extends Password{
    private static final String PASS_PATTERN = "/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/g";

    public PasswordIntermedia() {
        super(PASS_PATTERN);
    }

}
