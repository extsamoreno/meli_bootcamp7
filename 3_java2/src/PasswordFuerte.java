public class PasswordFuerte extends Password{
    public PasswordFuerte() {
        super();
        this.setRegex("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{15,}");
    }
}
