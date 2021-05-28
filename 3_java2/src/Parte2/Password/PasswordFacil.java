package Parte2.Password;

public class PasswordFacil extends Password{

    /*
    *Mínimo 8 caracteres, al menos una letra y un número
    */

    public static final String regex = "^(?=.*\\d)(?=.)(?=.*[a-zA-Z])\\S{8,16}$";
    String securepassword;

    public PasswordFacil(String password) throws Exception {
        super(password, regex);
        this.securepassword = super.setValue();
    }
}


