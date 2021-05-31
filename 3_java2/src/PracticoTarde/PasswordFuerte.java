package PracticoTarde;

public class PasswordFuerte extends Password{
    private static final String PASS_PATTERN = "/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[a-zA-Z]).{8,}$/g";

    public PasswordFuerte() {
        super(PASS_PATTERN);
    }
}
