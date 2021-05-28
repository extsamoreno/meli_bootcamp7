package tarde;

public class Password {

    private String pass;
    private String regex;

    public String getValue() {
        return pass;
    }

    public String getRegex() {
        return regex;
    }

    public void setValue(String value) throws Exception {
        if(value.matches(this.regex))
            this.pass = value;
        else
            throw new Exception("Password not match");
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public Password(){}

    public Password(String regex){
        super();
        this.regex = regex;
    }

    public boolean validatePass(String pass){

            try {
                setValue(pass);
                return true;
            } catch (Exception e) {
                return false;
            }


    }

}
