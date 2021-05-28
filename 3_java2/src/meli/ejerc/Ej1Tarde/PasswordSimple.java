package meli.ejerc.Ej1Tarde;

public class PasswordSimple extends Password{
    public PasswordSimple(String pass) throws Exception {
        super(pass, "^(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
    }
}
