import java.util.regex.*;

public class Password {
    private String password = "";
    private Pattern regex;


    public Password(){

    }

    public Password(Pattern pattern, String password){
    this.regex = pattern;
    setValue(password);
    }


    public void setValue(String pwd){
        Matcher match = this.regex.matcher(pwd);
        try {
            if(match.matches())
            this.password = pwd;
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[a-zA-Z]{1,5}");
        String str = "aaAAA";
        Password pass = new Password(pattern,str);

        System.out.println(pass.password);


    }




}
