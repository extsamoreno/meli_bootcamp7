package clasesTardeEjercicio1;

public class PasswordIntermedia extends Password{

    private static final String REGEX_INTERMEDIO=".(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*)(?=\\\\S+$).{8,}";

    public PasswordIntermedia(String regex) {
        super(REGEX_INTERMEDIO);
    }
}
