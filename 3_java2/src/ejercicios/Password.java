package ejercicios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Password {
    private String regex;

    public Password(String regex) {
        this.regex = regex;
    }

    public Password() {

    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    // Function to validate the password.
    public void setValue(String password) {

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        //Matcher encuentra matchs entre la pass y la regex
        Matcher m = p.matcher(password);

        //busca coincidencias para verificar contraseña segura
        boolean secure=m.matches();
        if(secure){
            System.out.println("La contraseña es segura");
        }else{
        throw new SecurityException("La contraseña no es segura");
        }
    }
}