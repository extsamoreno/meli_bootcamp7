public class PasswordIntermedia extends Password{

    public PasswordIntermedia() {
        super("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,}$");
    }
}
