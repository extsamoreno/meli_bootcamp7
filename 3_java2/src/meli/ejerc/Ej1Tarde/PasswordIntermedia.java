package meli.ejerc.Ej1Tarde;

public class PasswordIntermedia extends Password{
    public PasswordIntermedia(String pass) throws Exception {
        super(pass, "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
    }
}
