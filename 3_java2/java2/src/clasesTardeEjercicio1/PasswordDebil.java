package clasesTardeEjercicio1;

public class PasswordDebil extends Password{

    private static final String REGEX_DEBIL=".{4,}";

    public PasswordDebil(String regex) {
        super(REGEX_DEBIL);
    }


}
