public class PasswordIntermedio extends Password{

    public PasswordIntermedio() {
        super("^(?=.*[A-Za-z])(?=.*\\)(?=.*[@$!%*#?&])[A-Za-z\\@$!%*#?&]{8,}$");
    }
}
