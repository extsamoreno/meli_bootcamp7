public class PasswordSimple extends Password{

    public PasswordSimple() {
        super("^(?=.*[0-9])(?=.*[a-z]).{5,}$");
    }
}