package ejercicioTarde;

public class PasswordSimple extends Password{

    public PasswordSimple(String password) throws Exception {
        super(password,  "[a-zA-Z]{5,10}");
    }

}
