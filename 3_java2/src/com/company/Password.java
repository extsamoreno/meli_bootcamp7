package com.company;
import java.util.regex.*;

public abstract class Password {
    String value;
    String regex;

    public String getPassword() {
        return value;
    }

    public void setValue(String value) throws InstantiationException {
        this.value = value;
        this.testRegex(this.regex);
    }

    public void testRegex(String regex) throws InstantiationException {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.value);
        boolean matchFound = matcher.find();
        if(!matchFound) throw new InstantiationException();

        return;
    }
}
