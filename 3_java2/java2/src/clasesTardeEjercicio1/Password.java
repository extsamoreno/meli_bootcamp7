package clasesTardeEjercicio1;

public abstract class Password {

    private String regex;
    private String value;

    public Password(String regex) {
        this.regex=regex;
    }


    public String getValue() {
        return this.value;
    }

    public void setValue(String password) throws IllegalArgumentException {
        boolean matchFound = password.matches(regex);

        if(matchFound){
            this.value = password;
        } else {
            throw new IllegalArgumentException("Password Ivalida");
        }
    }
}
