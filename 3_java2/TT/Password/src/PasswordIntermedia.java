public class PasswordIntermedia extends Password {
    public PasswordIntermedia () {
        super();
        establecerExpresionRegular("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{13,}");
    }
}
