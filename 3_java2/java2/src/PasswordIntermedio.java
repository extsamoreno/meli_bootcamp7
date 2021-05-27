import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordIntermedio extends Password{

    private Pattern regex = Pattern.compile("^[^\\d].*(?=.*[0-9])(?=.*[a-z])");


    public PasswordIntermedio(Pattern pattern) {
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
