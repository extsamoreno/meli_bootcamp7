package tarde;

public class PasswordSimple extends Password{

    final String REGEX = "^{8,20}$";

    public PasswordSimple(String value){
        super();
        this.setRegex(REGEX);
    }


}
