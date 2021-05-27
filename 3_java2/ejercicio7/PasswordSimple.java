package ejercicio7;

public class PasswordSimple extends ejercicio7.Password {
    public PasswordSimple() {
        //Minimo 8 caracteres con al menos una letra y un número
        super("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }
}