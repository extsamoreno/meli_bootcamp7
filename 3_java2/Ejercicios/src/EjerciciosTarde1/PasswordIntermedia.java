package EjerciciosTarde1;

public class PasswordIntermedia extends Password {

    public PasswordIntermedia() {
        super("^.*(?=.{6,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$");
    }
}
