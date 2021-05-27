package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private String password;
    private String regex;

    public Password(String password, String regex) throws Exception {
        this.regex = regex;
        setValue(password);
    }

    public void setValue(String password) throws Exception {
        if (testRegex(password)){
            this.password = password;
        } else {
            throw new Exception("Password doesn't comply with requirements");
        }
    }

    private boolean testRegex(String password){
        Pattern pattern = Pattern.compile(this.regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }


}