package ejercicio_password;

import ejercicio_password.Password;

public class PasswordFuerte extends Password {
    public PasswordFuerte(String regex) {
        super(regex);
        this.regex = "^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
    }
}
