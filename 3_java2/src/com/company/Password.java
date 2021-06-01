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
        //Definimos el regex
        Pattern pattern = Pattern.compile(regex);
        //Creamos un matcher para nuestro regex
        Matcher matcher = pattern.matcher(this.value);
        //Si coincide con el regex, es true, si no, es porque no cumplio
        boolean matchFound = matcher.find();
        //Si no cumplio,
        if(!matchFound) throw new InstantiationException();

    }
}
