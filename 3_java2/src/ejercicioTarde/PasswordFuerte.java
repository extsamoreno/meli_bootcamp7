package ejercicioTarde;

public class PasswordFuerte extends Password{

    public PasswordFuerte(String password) throws Exception {
        super(password,  "[a-zA-Z]{5,10}");
    }

}
