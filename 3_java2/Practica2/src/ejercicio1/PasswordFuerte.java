package ejercicio1;

public class PasswordFuerte extends Password {

    private final String REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    public PasswordFuerte() {
        super();
        this.setRegex(this.REGEX);
    }
}
