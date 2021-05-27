package ejercicioTarde;

public class PasswordIntermedia extends Password{

    public PasswordIntermedia(String password) throws Exception {
        super(password,  "[a-zA-Z]{5,10}");
    }

}
