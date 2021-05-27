package password;

public class PasswordFuerte extends Password {
    public PasswordFuerte() {
        //comprobar si un email es válido:
        super("[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }
}
