package clasesTardeEjercicio1;

public class PasswordFuerte extends  Password{

    private static final String REGEX_FUERTE="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*])(?=\\\\S+$).{12,}";

    public PasswordFuerte(String regex) {
        super(REGEX_FUERTE);
    }
}
