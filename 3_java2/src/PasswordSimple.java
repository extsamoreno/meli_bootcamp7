public class PasswordSimple extends Password{

    public PasswordSimple() {
        super();
        this.setRegex("(?=.+[a-zA-Z])+(?=.+[0-9])+.{8,}");

    }
}
