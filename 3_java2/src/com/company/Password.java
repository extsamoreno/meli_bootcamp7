package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public abstract class Password {

    private String password;
    private String regex;

    public Password() {
        this.password = "";
    }

    public Password(String regex){
        this.regex = regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public boolean isValid(){
        try {
            Pattern pattern = Pattern.compile(this.regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(this.password);
            return matcher.find();
        }catch (PatternSyntaxException e){
            return false;
        }
    }

    public void setValue(String password ){
        this.password = password;
        if(this.isValid()){
            this.password = password;
        }else{
            this.password = "";
            throw new PatternSyntaxException("Fails value regex", password, -1);
        }
    }

}
