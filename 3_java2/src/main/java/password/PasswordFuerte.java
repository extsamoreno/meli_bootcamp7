package password;

public class PasswordFuerte extends Password{

    //minimo ocho caracteres, al menos una mayuscula, una minuscula, un numero y un caracter especial
    public PasswordFuerte() {
        super("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,}$");
    }
}
