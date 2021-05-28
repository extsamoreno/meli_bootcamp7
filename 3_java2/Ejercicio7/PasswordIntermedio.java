package Ejercicio7;

public class PasswordIntermedio extends Password {

    public PasswordIntermedio() {
        super("^.*(?=.{6,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$");
    }
}
