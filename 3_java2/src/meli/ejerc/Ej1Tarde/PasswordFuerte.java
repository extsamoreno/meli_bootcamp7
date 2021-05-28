package meli.ejerc.Ej1Tarde;

public class PasswordFuerte extends Password{
    public PasswordFuerte(String pass) throws Exception {
        super(pass, "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }
}
