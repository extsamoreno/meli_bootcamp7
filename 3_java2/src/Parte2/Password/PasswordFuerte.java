package Parte2.Password;

public class PasswordFuerte extends Password {
    /*
    * La contraseña debe tener al entre 10 y 16 caracteres,
    * al menos un dígito, al menos una minúscula, al menos una mayúscula y
    *  al menos un caracter no alfanumérico.
    * */

    String securepassword;

    public static final String regex = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[a-zA-Z])\\S{10,16}$";
    PasswordFuerte(String password) throws Exception {
        super(password, regex);
        this.securepassword = super.setValue();
    }

}