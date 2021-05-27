package Parte2.Password;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class Password {
    private String password;
    private String regex;

    public Password(String password, String regex) {
        this.password = password;
        this.regex = regex;
    }

    public boolean checkPassword(String regex, String password){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.find();
    }

    public String setValue() throws Exception {
        if(this.checkPassword(this.regex, this.password) == true){
            System.out.println("Secure password");
            return this.password;
        }else{
            throw new Exception("Password not secure");
        }
    }

}
