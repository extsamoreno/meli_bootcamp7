package practicaTT.password;

public class PasswordIntermedia extends Password {
    //Minimum eight characters, at least one letter, one number and one special character
    public PasswordIntermedia() {
        super("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }
}
