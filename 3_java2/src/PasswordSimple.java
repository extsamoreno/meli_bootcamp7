public class PasswordSimple extends Password {
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9]).{8,20}$";

    public PasswordSimple() {
        super(PASSWORD_PATTERN);
    }
}
