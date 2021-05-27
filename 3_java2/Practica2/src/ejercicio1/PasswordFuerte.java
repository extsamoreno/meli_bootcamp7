package ejercicio1;

public class PasswordFuerte extends Password {

    public static final String REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    public PasswordFuerte(String value) {
        super();
        this.setRegex(REGEX);
    }
}
