package tt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    private String pwd;

    public Password (String pwd){

        Pattern pat = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:]).{8,20}");
        Matcher mat = pat.matcher(pwd);

        if(mat.find()){
            System.out.println("tt.Password válido");
        } else{
            System.out.println("tt.Password no válido");
        }
    }
}
