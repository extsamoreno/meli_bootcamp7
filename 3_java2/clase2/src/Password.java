import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public abstract class Password {
    
    private String value;
    private String regex;

    public Password(String regex){
        this.regex = regex;
    }


    public String getValue() {
        return value;
    }

    private boolean validate(String password){

        try {

            Pattern pattern = Pattern.compile(this.regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(password);
    
            return matcher.find();

        } catch (PatternSyntaxException e) {

            throw e;

        }


    }

    public void setValue(String value) {

        try {
            if(this.validate(value)) {
                this.value = value;
            }

        } catch (Exception e) {
            throw e;
        }
 
    }


}
