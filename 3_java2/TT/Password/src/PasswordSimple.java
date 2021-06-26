public class PasswordSimple extends Password {
    public PasswordSimple (String regex) {
        super();
        this.establecerExpresionRegular("(?=.+[a-zA-Z])+(?=.+[0-9])+.{8,}");
    }
}
