public class PasswordFuerte extends Password{


    public PasswordFuerte() {
        super("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{10,20}$");
    }
}
