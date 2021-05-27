package Exercise1;

public class PasswordFuerte extends Password {
    //Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character
    public PasswordFuerte() {
        super("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }
}