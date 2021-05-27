package Parte2.Password;

public class PasswordMedio extends Password{

    /*
    *Mínimo 10 caracteres, al menos una letra y un número
     */

    public static final String regex = "^(?=.*\\d)(?=.)(?=.*[A-Z])(?=.*[a-z])\\S{10,16}$";
    String securepassword;

    PasswordMedio(String password) throws Exception {
        super(password, regex);
        this.securepassword = super.setValue();
    }
}

