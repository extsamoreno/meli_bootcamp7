package ejercicios;

public class PasswordSimple extends Password {
    public PasswordSimple() {
        this.setRegex("^(?=.*[0-9])" + "(?=\\S+$).{4,20}$");
    }

}
