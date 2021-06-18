public class PasswordIntermedia extends Password {
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";

    public PasswordIntermedia() {
        super(PASSWORD_PATTERN);
    }


}