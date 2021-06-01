public class PasswordIntermedia extends Password {
    private static final String PASSWORD_MEDIA =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])";

    public PasswordIntermedia() {
        super(PASSWORD_MEDIA);
    }
}
