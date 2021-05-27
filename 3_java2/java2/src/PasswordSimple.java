import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordSimple extends Password{


    private Pattern regex = Pattern.compile("^[^\\d].*(?=.*[0-9])");

    public PasswordSimple(Pattern pattern) {
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
