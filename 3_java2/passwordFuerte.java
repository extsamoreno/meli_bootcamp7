public class passwordFuerte extends Password{

    private static final String PASSWORD_FUERTE =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    public passwordFuerte() {
        super(PASSWORD_FUERTE);
    }


}