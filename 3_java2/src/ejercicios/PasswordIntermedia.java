package ejercicios;
public class PasswordIntermedia extends Password {
    public PasswordIntermedia() {
        this.setRegex("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=\\S+$).{8,20}$");
    }
}
