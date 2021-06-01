public class PasswordSimple extends Password{


    public PasswordSimple() {
        super("^(?=.*[a-z]).{2,8}$");
    }
}
