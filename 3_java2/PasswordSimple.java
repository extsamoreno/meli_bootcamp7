public class PasswordSimple extends Password{

    public PasswordSimple() {
        super("^(?=.*[A-Za-z])(?=.*\\)[A-Za-z\\]{8,}$");
    }

}
