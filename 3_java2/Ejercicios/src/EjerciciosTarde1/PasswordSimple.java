package EjerciciosTarde1;

public class PasswordSimple extends Password {

    public PasswordSimple() {
        super("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,}$");
    }
}
