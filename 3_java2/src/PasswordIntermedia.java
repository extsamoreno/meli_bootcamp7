public class PasswordIntermedia extends Password{

    public PasswordIntermedia() {
        super("^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{8,10}$");
    }
}
