public class PasswordFuerte extends Password {
    public PasswordFuerte () {
        super();
        establecerExpresionRegular("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{15,}");
    }
}
