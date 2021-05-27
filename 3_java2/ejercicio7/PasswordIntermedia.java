package ejercicio7;

public class PasswordIntermedia extends ejercicio7.Password {
    public PasswordIntermedia() {
        //Mínimo 8 caracteres con al menos una letra, un número y un caracter especial
        super("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }
}