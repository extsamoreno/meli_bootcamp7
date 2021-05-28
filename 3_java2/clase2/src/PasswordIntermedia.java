public class PasswordIntermedia extends Password{

    public PasswordIntermedia(){

        super("^(?=.*[a-z])(?=.*[A-Z])(?=.*)(?=.*[@$!%*?&])[A-Za-z@$!%*?&]{8,10}$");
    }
    
}
