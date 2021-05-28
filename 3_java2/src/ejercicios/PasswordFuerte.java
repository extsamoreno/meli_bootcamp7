package ejercicios;

public class PasswordFuerte extends Password {
    public PasswordFuerte() {
        this.setRegex("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])" + "(?=\\S+$).{16,100}$");
    }
}

