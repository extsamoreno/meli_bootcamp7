package meli.ejerc;

public class PasswordFuerte extends Password {
    private static final String REGEXP = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    public PasswordFuerte() {
        super(REGEXP);
    }
}
