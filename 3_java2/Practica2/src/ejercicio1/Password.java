package ejercicio1;

public class Password {
    public String value;
    public String regex;

    public Password(String value) {
        this.value = value;
        //this.regex = regex;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) throws Exception {
        String msg = "Password do not match";

        this.value = value;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

}


