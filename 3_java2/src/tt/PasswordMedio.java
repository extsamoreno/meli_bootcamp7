package tt;

public class PasswordMedio extends Password {

    //Minimum eight characters, at least one letter, one number and one special character
    public PasswordMedio() {
        super("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }

}
