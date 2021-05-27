import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public abstract class Password {

   private String value;
   private String regex;

    public Password(String regex) {
        this.regex = regex;
    }

    private boolean validate(String password){
        try{
            Pattern pattern = Pattern.compile(this.regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(password);
            return matcher.find();
        }catch(PatternSyntaxException e){
            return false;
        }
    }

    public void setValue(String value) {
       try {
           validate(value);
           this.value = value;
           System.out.println("Todo ok");
       }catch(Exception e){
           throw e;
       }
    }


}
