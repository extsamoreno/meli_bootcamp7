package meli.ejerc.Ej1Tarde;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private String pass;
    private String regex;

    public Password(String pass, String regex) throws Exception{
        this.regex = regex;
        setValue(pass);
    }

    private boolean testRegex(String pass) {
        Pattern pattern = Pattern.compile(this.regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(pass);
        return matcher.find();
    }

    public void setValue(String pass) throws Exception{
        if (testRegex(pass)){
            this.pass = pass;
            System.out.println("Password meets security requirements");
        } else {
            throw new Exception("Password does not meet the minimum security requirements.");
        }
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
