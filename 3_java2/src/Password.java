public class Password {
    private String regex;
    private String password;

    public Password() {
    }

    public Password(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public void setValue(String pwd){
        if(pwd.matches(regex)) {
            this.password=pwd;
        } else {
            throw new SecurityException("La contraseña no cumple los requisitos de seguridad");
        }
    }
}
