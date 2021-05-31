package PracticoTarde;

import javax.swing.*;
import java.util.regex.Pattern;

public class Password {
    private String patterns;
    private String pwd;

    public Password(){
        this.patterns = "";
        this.pwd = "";
    }

    public Password(String patterns){
        this.patterns = patterns;
    }

    public void setValue(String pwd) throws Exception{
        if(pwd.matches(this.patterns)){
            this.pwd = pwd;
        }else{
            throw new Exception("El password no cumple con los requisitos");
        }
    }
}
