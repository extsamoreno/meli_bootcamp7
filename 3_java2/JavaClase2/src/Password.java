import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    private String pwd;
    private Matcher matcher;

    public void setMatcher(String regex, String input){
        Pattern pat = Pattern.compile(regex);
       this.matcher = pat.matcher(input);
    }

    public boolean validPass(){
        return getMatcher().matches();
    }

    public Matcher getMatcher() {
        return this.matcher;
    }

    public void setPass(String pwd){
        this.pwd = pwd;
    }

    public String getPass(){
        return this.pwd;
    }

    public void generatePass(String regex, String pwd){
        this.setMatcher(regex, pwd);
        if (this.validPass()){
            this.setPass(pwd);
            System.out.println("Pass guardada");
        }else {
            System.out.println("Pass invàlida");
        }
    }
}






