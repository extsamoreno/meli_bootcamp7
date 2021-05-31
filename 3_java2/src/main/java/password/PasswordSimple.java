package password;

public class PasswordSimple extends Password{
        //minimo 8 caracteres, al menos una letra y un numero
        public PasswordSimple() {
                super("^(?=.*[0-9])(?=.*[A-Za-z])(?=\\\\S+$).{8,}$");
        }
}
