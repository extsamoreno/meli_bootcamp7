import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordFuerte extends Password{

    private Pattern regex = Pattern.compile("^[^\\d].*(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])");


    public PasswordFuerte(Pattern pattern) {
        this.regex = pattern;
    }
    @Override
    public void setValue(String pwd){
        Matcher match = this.regex.matcher(pwd);
        try {
            match.matches();
            System.out.println("Todo ok");
        }catch(Exception e){
            e.printStackTrace();
        }

    }



}
