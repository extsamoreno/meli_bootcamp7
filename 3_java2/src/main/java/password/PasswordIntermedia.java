package password;

public class PasswordIntermedia  extends Password{

    //minimo ocho caracteres, al menos una letra, un numero y un caracter especial
    public PasswordIntermedia() {
        super("^(?=.*[0-9])(?=.*[A-Za-z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,}$");
    }
}
