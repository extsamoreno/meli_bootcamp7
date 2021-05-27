public class PasswordFuerte extends Password{

    public PasswordFuerte() {
        super("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\)(?=.*[@$!%*?&])[A-Za-z\\@$!%*?&]{8,10}$");
    }



}
