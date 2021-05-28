package ejercicio1;

public class Password {

    public String value;
    public String regex;

    public Password() {
    }

    public Password(String regex) {
        this.regex = regex;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) throws Exception {
        if(value.matches(this.regex)) {
            this.value = value;
        } else {
            throw new Exception("Password no concuerda con regex.");
        }
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}


