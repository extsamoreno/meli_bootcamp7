package Ejercicio7;

public class PasswordFuerte extends Password {

    public PasswordFuerte() {
        super("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$");
    }
}
