public class PasswordIntermedia extends Password{
    public PasswordIntermedia() {
        super();
        this.setRegex("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{13,}");

    }
}
