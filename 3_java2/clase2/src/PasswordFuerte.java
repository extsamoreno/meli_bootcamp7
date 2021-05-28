public class PasswordFuerte extends Password{

    public PasswordFuerte(){

        super("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$");
    }
    
}
