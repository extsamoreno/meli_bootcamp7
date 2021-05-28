package TT.ej1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Password {
    private String password;
    protected String regex;

    public abstract void Password(String regex);



    public void setValue(String pwd) throws Exception {
        System.out.println("Estoy entrando a set value" + this.regex);
        this.password = pwd;

        Pattern pattern = Pattern.compile(this.regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.password);
        boolean match = matcher.find();

        System.out.println("bool validate: " +match);
        if(match) {
            System.out.println("Match found");
        } else {
            System.out.println("Match NOT found");
            throw new Exception("Exception");
        }
    }
}
