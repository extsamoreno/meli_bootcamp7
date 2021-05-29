public class PasswordFuerte extends Password{

    // digit + lowercase char + uppercase char + punctuation + symbol
    private static final String PASSWORD_FUERTE =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    public PasswordFuerte(){
        super(PASSWORD_FUERTE);
    }
}
